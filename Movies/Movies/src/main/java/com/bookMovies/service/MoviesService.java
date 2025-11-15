package com.bookMovies.service;

import com.bookMovies.exception.MoviesNotFoundException;
import com.bookMovies.model.Movies;

import java.util.List;

public interface MoviesService {

    Movies addMovie(Movies movie);
    boolean removeMovie(String title) throws MoviesNotFoundException;
    Movies updateMovie(Movies movie) throws MoviesNotFoundException;
    List<Movies> getAllMovies();
    boolean isIdExist(Long id);
}
