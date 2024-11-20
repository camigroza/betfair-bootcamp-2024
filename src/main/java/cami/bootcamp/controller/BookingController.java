package cami.bootcamp.controller;

import cami.bootcamp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public void createBooking() {

    }

    @GetMapping
    public void getAllBookings() {

    }

    @GetMapping("/{bookingId}")
    public void getBooking(@PathVariable Long bookingId) {

    }
}
