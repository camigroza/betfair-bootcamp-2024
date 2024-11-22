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

    public BookingBuilder includeBreakfast() {
        this.breakfastIncluded = true;
        return this;
    }

    public BookingBuilder includeDinner() {
        this.dinnerIncluded = true;
        return this;
    }

    public BookingBuilder includeSpa() {
        this.spaAccess = true;
        return this;
    }

    public BookingBuilder includeAirportPickup() {
        this.airportPickup = true;
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
