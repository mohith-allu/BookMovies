package com.bookMovies.service;

import com.bookMovies.exception.TheatreNotFoundException;
import com.bookMovies.model.Theatre;
import com.bookMovies.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService{
    @Autowired
    private TheatreRepository repository;

    @Override
    public Theatre addTheatre(Theatre theatre) {
        return repository.save(theatre);
    }

    @Override
    public boolean removeTheatre(String name) throws TheatreNotFoundException {
        if(!repository.existsByName(name)){
            throw new TheatreNotFoundException("Theatre name doesn't exist");
        }
        repository.deleteById(repository.findIdByName(name));
        return true;
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return repository.findAll();
    }
}
