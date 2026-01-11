package com.bookMovies.client;

import com.bookMovies.dto.MovieDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="movies-service",path = "/api/movies")
public interface MoviesServiceFeign {
    @GetMapping("/exist/{id}")
    boolean isIdExist(@PathVariable("id") Long id);

    @GetMapping("/getDetails/{id}")
    MovieDetails details(@PathVariable("id") Long id);
}
