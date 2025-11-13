package com.bookMovies.controller;

import com.bookMovies.dto.MovieTitle;
import com.bookMovies.exception.MoviesNotFoundException;
import com.bookMovies.model.Movies;
import com.bookMovies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {
    @Autowired
    private MoviesService service;

    @PostMapping("/addMovie")
    public Movies addMovies(@RequestBody Movies movie){
        return service.addMovie(movie);
    }

    @DeleteMapping("/deleteMovie")
    public boolean deleteMovie(@RequestBody MovieTitle title) throws MoviesNotFoundException {
        return service.removeMovie(title.getTitle());
    }

    @GetMapping("/listAllMovies")
    public List<Movies> getAllMovies(){
        return service.getAllMovies();
    }
}
