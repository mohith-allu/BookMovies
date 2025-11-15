package com.bookMovies.service;

import com.bookMovies.exception.MoviesNotFoundException;
import com.bookMovies.model.Movies;
import com.bookMovies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository repository;

    @Override
    public Movies addMovie(Movies movie) {
        return repository.save(movie);
    }

    @Override
    public boolean removeMovie(String title) throws MoviesNotFoundException {
        if(!repository.existsByTitle(title)){
            throw new MoviesNotFoundException("The movie doesn't exist");
        }
        repository.deleteById(repository.getIdByTitle(title));
        return true;
    }

    @Override
    public Movies updateMovie(Movies movie) throws MoviesNotFoundException{
        if(repository.findById(movie.getId()).isEmpty()){
            throw new MoviesNotFoundException("No movie with such id exist");
        }
        return repository.save(movie);
    }

    @Override
    public List<Movies> getAllMovies() {
        return repository.findAll();
    }
}
