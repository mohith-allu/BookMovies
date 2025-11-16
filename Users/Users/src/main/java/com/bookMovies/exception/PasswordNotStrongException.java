package com.bookMovies.exception;

public class PasswordNotStrongException extends Exception {
    public PasswordNotStrongException(String message) {
        super(message);
    }
}
