package com.bookMovies.service;

import com.bookMovies.dto.SeatsRequest;
import com.bookMovies.exception.WrongPairOfTheatreIdAndScreenNumberException;
import com.bookMovies.model.Seats;

import java.util.List;

public interface SeatsService {
    Seats addSeats(Seats seats);
    boolean removeSeats(Long theatreId,int screenNumber) throws WrongPairOfTheatreIdAndScreenNumberException;
    List<SeatsRequest> getSeatsByTheatreIdAndScreenNumber(Long theatreId,int screenNumber)
                                throws WrongPairOfTheatreIdAndScreenNumberException;
}
