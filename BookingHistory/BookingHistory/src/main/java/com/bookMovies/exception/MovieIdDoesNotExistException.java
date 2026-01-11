package com.bookMovies.exception;

public class MovieIdDoesNotExistException extends Exception {
    public MovieIdDoesNotExistException(String message) {
        super(message);
    }
}
