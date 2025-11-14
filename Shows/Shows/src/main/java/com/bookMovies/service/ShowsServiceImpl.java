package com.bookMovies.service;

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
    @Override
    public Shows addShows(Shows show) {
        Shows shows=repository.save(show);
        showSeatsService.addShowSeats(shows.getId(),shows.getTheatreId(), shows.getScreenNumber());
        return shows;
    }
}
