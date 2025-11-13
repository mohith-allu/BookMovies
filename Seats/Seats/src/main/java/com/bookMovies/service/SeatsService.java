package com.bookMovies.service;

import com.bookMovies.exception.WrongPairOfTheatreIdAndScreenNumberException;
import com.bookMovies.model.Seats;

public interface SeatsService {
    Seats addSeats(Seats seats);
    boolean removeSeats(Long theatreId,int screenNumber) throws WrongPairOfTheatreIdAndScreenNumberException;
}
