package com.bookMovies.service;

import com.bookMovies.exception.TheatreNotFoundException;
import com.bookMovies.model.Theatre;

import java.util.List;

public interface TheatreService {
    Theatre addTheatre(Theatre theatre);
    boolean removeTheatre(String name) throws TheatreNotFoundException;
    Theatre updatetheatre(Theatre theatre) throws TheatreNotFoundException;
    List<Theatre> getAllTheatres();
    boolean isIdExist(Long id);
}
