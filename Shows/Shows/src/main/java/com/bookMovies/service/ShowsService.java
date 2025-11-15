package com.bookMovies.service;

import com.bookMovies.exception.MovieIdDoesNotExistException;
import com.bookMovies.exception.TheatreIdDoesNotExistException;
import com.bookMovies.exception.WrongPairOfTheatreIdAndScreenNumberException;
import com.bookMovies.model.Shows;

public interface ShowsService {

    Shows addShows(Shows show) throws MovieIdDoesNotExistException,
                            TheatreIdDoesNotExistException, WrongPairOfTheatreIdAndScreenNumberException;

}
