package cami.bootcamp.controller;

import cami.bootcamp.model.Booking;
import cami.bootcamp.model.DTO.BookingDto;
import cami.bootcamp.model.exception.BadBookingRequestException;
import cami.bootcamp.model.exception.BadRoomRequestException;
import cami.bootcamp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody @Validated BookingDto bookingToCreate) throws BadBookingRequestException, BadRoomRequestException {
        return bookingService.createBooking(bookingToCreate);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable Long bookingId) throws BadBookingRequestException {
        return bookingService.getBookingById(bookingId);
    }

    @DeleteMapping("/{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) throws BadRoomRequestException {
        bookingService.cancelBooking(bookingId);
        return "Booking canceled successfully";
    }

    @ExceptionHandler({BadBookingRequestException.class, BadRoomRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleExceptions(Exception exception) {
        return exception.getMessage();
    }
}
