package com.bookMovies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class TheatreExceptionHandler {

    @ExceptionHandler(TheatreNotFoundException.class)
    public ResponseEntity<Error> theatreNotFound(TheatreNotFoundException exception, WebRequest request){
        Error error=new Error(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
