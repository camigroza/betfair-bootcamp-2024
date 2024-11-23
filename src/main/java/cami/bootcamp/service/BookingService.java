package cami.bootcamp.service;

import cami.bootcamp.model.Booking;
import cami.bootcamp.model.BuilderPattern.BookingBuilder;
import cami.bootcamp.model.DTO.BookingDto;
import cami.bootcamp.model.Room;
import cami.bootcamp.model.StatePattern.RoomContext;
import cami.bootcamp.model.exception.BadBookingRequestException;
import cami.bootcamp.model.exception.BadRoomRequestException;
import cami.bootcamp.repository.BookingRepository;
import cami.bootcamp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public Booking createBooking(BookingDto bookingToCreate) throws BadBookingRequestException, BadRoomRequestException {
        Room room = roomRepository.findById(bookingToCreate.roomId())
                .orElseThrow(() -> new BadBookingRequestException("Room for booking not found"));

        if (!room.getState().equalsIgnoreCase("available")) {
            throw new BadBookingRequestException("Room is not available for booking");
        }

        if(bookingToCreate.checkInDate().isAfter(bookingToCreate.checkOutDate())) {
            throw new BadBookingRequestException("Check-out date must be after check-in date");
        }

        Booking booking = new BookingBuilder()
                .setRoom(room)
                .setCheckInDate(bookingToCreate.checkInDate())
                .setCheckOutDate(bookingToCreate.checkOutDate())
                .setCustomerName(bookingToCreate.customerName())
                .includeBreakfast(bookingToCreate.breakfastIncluded())
                .includeDinner(bookingToCreate.dinnerIncluded())
                .includeAirportPickup(bookingToCreate.airportPickup())
                .includeSpa(bookingToCreate.spaAccess())
                .build();

        Booking savedBooking = bookingRepository.save(booking);

        RoomContext context = new RoomContext(room);
        context.reserve();
        roomRepository.save(room);

        return savedBooking;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long bookingId) throws BadBookingRequestException {
        return bookingRepository.findById(bookingId).orElseThrow(() -> new BadBookingRequestException("Booking not found"));
    }

    public void cancelBooking(Long bookingId) throws BadRoomRequestException {
        Booking bookingToDelete = bookingRepository.findById(bookingId).orElse(null);
        if(bookingToDelete != null) {
            Room room = bookingToDelete.getRoom();
            RoomContext context = new RoomContext(room);
            context.makeAvailable();
            roomRepository.save(room);
            bookingRepository.delete(bookingToDelete);
        }
    }
}
