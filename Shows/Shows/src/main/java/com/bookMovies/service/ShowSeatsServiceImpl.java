package com.bookMovies.service;

import com.bookMovies.client.SeatsServiceFeign;
import com.bookMovies.dto.SeatsRequest;
import com.bookMovies.exception.WrongPairOfTheatreIdAndScreenNumberException;
import com.bookMovies.model.ShowSeats;
import com.bookMovies.repository.ShowSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShowSeatsServiceImpl implements ShowSeatsService{

    @Autowired
    private SeatsServiceFeign seatsServiceFeign;
    @Autowired
    private ShowSeatsRepository repository;

    @Override
    public void addShowSeats(Long showId, Long theatreId, int screenNumber)
            throws WrongPairOfTheatreIdAndScreenNumberException {

        List<SeatsRequest> seats=seatsServiceFeign.getSeatsByTheatreIdAndScreenNumber(theatreId,screenNumber);
        if(seats==null){
            throw new WrongPairOfTheatreIdAndScreenNumberException("No such Theatre ID and screen number exist");
        }
        for(SeatsRequest seat:seats){
            repository.save(new ShowSeats(showId,seat.getSeatType(),
                    seat.getTotalSeats(),seat.getPrice()));
        }
    }
}
