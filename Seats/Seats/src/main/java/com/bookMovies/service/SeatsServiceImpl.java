package com.bookMovies.service;

import com.bookMovies.exception.WrongPairOfTheatreIdAndScreenNumberException;
import com.bookMovies.model.Seats;
import com.bookMovies.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsServiceImpl implements SeatsService{
    @Autowired
    private SeatsRepository repository;

    @Override
    public Seats addSeats(Seats seats) {
        return repository.save(seats);
    }

    @Override
    public boolean removeSeats(Long theatreId, int screenNumber) throws WrongPairOfTheatreIdAndScreenNumberException {
        if(!repository.existsByTheatreIdAndScreenNumber(theatreId,screenNumber)){
            throw new WrongPairOfTheatreIdAndScreenNumberException("Theatre ID and screen number doesn't match");
        }
        List<Long> ids=repository.getIdByTheatreIdAndScreenNumber(theatreId,screenNumber);
        for(Long id:ids){
            repository.deleteById(id);
        }
        return true;
    }
}
