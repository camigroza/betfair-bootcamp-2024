package cami.bootcamp.model.BuilderPattern;

import cami.bootcamp.model.Booking;
import cami.bootcamp.model.Room;

import java.time.LocalDate;

public class BookingBuilder {

    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String customerName;
    private boolean breakfastIncluded;
    private boolean dinnerIncluded;
    private boolean spaAccess;
    private boolean airportPickup;

    public BookingBuilder setRoom(Room room) {
        this.room = room;
        return this;
    }

    public BookingBuilder setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
        return this;
    }

    public BookingBuilder setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
        return this;
    }

    public BookingBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public BookingBuilder includeBreakfast(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
        return this;
    }

    public BookingBuilder includeDinner(boolean dinnerIncluded) {
        this.dinnerIncluded = dinnerIncluded;
        return this;
    }

    public BookingBuilder includeSpa(boolean spaAccess) {
        this.spaAccess = spaAccess;
        return this;
    }

    public BookingBuilder includeAirportPickup(boolean airportPickup) {
        this.airportPickup = airportPickup;
        return this;
    }

    public Booking build() {
        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);
        booking.setCustomerName(customerName);
        booking.setBreakfastIncluded(breakfastIncluded);
        booking.setDinnerIncluded(dinnerIncluded);
        booking.setSpaAccess(spaAccess);
        booking.setAirportPickup(airportPickup);
        return booking;
    }
}
