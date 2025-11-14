package com.bookMovies.controller;

import com.bookMovies.dto.SeatsDelete;
import com.bookMovies.dto.SeatsRequest;
import com.bookMovies.exception.WrongPairOfTheatreIdAndScreenNumberException;
import com.bookMovies.model.Seats;
import com.bookMovies.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatsController {
    @Autowired
    private SeatsService service;

    @PostMapping("/addSeats")
    public Seats addSeats(@RequestBody Seats seats){
        return service.addSeats(seats);
    }

    @DeleteMapping("/removeSeats")
    public boolean removeSeats(@RequestBody SeatsDelete delete) throws WrongPairOfTheatreIdAndScreenNumberException{
        return service.removeSeats(delete.getTheatreId(),delete.getScreenNumber());
    }

    @GetMapping("/{theatreId}/{screenNumber}")
    public List<SeatsRequest> getSeatsByTheatreIdAndScreenNumber(
            @PathVariable("theatreId") Long theatreId,@PathVariable("screenNumber") int screenNumber)
            throws WrongPairOfTheatreIdAndScreenNumberException{

        return service.getSeatsByTheatreIdAndScreenNumber(theatreId,screenNumber);
    }
}
