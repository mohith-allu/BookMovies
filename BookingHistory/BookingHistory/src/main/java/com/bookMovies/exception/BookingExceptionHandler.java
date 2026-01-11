package com.bookMovies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class BookingExceptionHandler {

    @ExceptionHandler(MovieIdDoesNotExistException.class)
    public ResponseEntity<Error> movieIdDoesNotExist(MovieIdDoesNotExistException exception, WebRequest request){
        Error error=new Error(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(TheatreIdDoesNotExistException.class)
    public ResponseEntity<Error> theatreIdDoesNotExist(TheatreIdDoesNotExistException exception,WebRequest request){
        Error error=new Error(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
