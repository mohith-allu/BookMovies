package com.bookMovies.controller;

import com.bookMovies.model.Shows;
import com.bookMovies.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shows")
public class ShowsController {
    @Autowired
    private ShowsService service;

    @PostMapping("/addShow")
    public Shows addShow(@RequestBody Shows show){
        return service.addShows(show);
    }
}
