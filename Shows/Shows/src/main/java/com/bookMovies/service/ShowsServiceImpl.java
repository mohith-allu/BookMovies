package com.bookMovies.service;

import com.bookMovies.client.MoviesServiceFeign;
import com.bookMovies.client.TheatreServiceFeign;
import com.bookMovies.exception.MovieIdDoesNotExistException;
import com.bookMovies.exception.TheatreIdDoesNotExistException;
import com.bookMovies.exception.WrongPairOfTheatreIdAndScreenNumberException;
import com.bookMovies.model.Shows;
import com.bookMovies.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowsServiceImpl implements ShowsService{
    @Autowired
    private ShowsRepository repository;
    @Autowired
    private ShowSeatsService showSeatsService;
    @Autowired
    private MoviesServiceFeign moviesServiceFeign;
    @Autowired
    private TheatreServiceFeign theatreServiceFeign;

    @Override
    public Shows addShows(Shows show) throws MovieIdDoesNotExistException,
            TheatreIdDoesNotExistException, WrongPairOfTheatreIdAndScreenNumberException {
        Shows shows=repository.save(show);
        if(moviesServiceFeign.isIdExist(shows.getMovieId())){
            throw new MovieIdDoesNotExistException("No such movie ID exist");
        }
        if(theatreServiceFeign.isIdExist(shows.getTheatreId())){
            throw new TheatreIdDoesNotExistException("No such theatre ID exist");
        }
        showSeatsService.addShowSeats(shows.getId(),shows.getTheatreId(), shows.getScreenNumber());
        return shows;
    }
}
