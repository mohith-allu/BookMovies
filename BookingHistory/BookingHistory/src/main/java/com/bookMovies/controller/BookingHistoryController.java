package com.bookMovies.controller;

import com.bookMovies.dto.Booking;
import com.bookMovies.exception.MovieIdDoesNotExistException;
import com.bookMovies.exception.TheatreIdDoesNotExistException;
import com.bookMovies.model.BookingHistory;
import com.bookMovies.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookingHistory")
public class BookingHistoryController {
    @Autowired
    private BookingService service;

    @PostMapping("/addBooking")
    public BookingHistory addBooking(@RequestBody Booking booking)
            throws MovieIdDoesNotExistException, TheatreIdDoesNotExistException{
        return service.addBooking(booking);
    }
}
