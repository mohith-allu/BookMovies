package com.bookMovies.service;

import com.bookMovies.dto.SeatsRequest;
import com.bookMovies.model.ShowSeats;

public interface ShowSeatsService {

    void addShowSeats(Long showId,Long theatreId,int screenNumber);
}
