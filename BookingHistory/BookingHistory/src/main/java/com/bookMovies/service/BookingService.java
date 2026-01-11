package com.bookMovies.service;

import com.bookMovies.dto.Booking;
import com.bookMovies.exception.MovieIdDoesNotExistException;
import com.bookMovies.exception.TheatreIdDoesNotExistException;
import com.bookMovies.model.BookingHistory;

public interface BookingService {
    BookingHistory addBooking(Booking booking)throws MovieIdDoesNotExistException, TheatreIdDoesNotExistException;
}
