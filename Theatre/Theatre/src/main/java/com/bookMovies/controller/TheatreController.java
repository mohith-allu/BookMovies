package com.bookMovies.controller;

import com.bookMovies.dto.TheatreName;
import com.bookMovies.exception.TheatreNotFoundException;
import com.bookMovies.model.Theatre;
import com.bookMovies.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatre")
public class TheatreController {
    @Autowired
    private TheatreService service;

    @PostMapping("/addTheatre")
    public Theatre addTheatre(@RequestBody Theatre theatre){
        return service.addTheatre(theatre);
    }

    @DeleteMapping("/removeTheatre")
    public boolean removeTheatre(@RequestBody TheatreName name) throws TheatreNotFoundException {
        return service.removeTheatre(name.getName());
    }

    @GetMapping("/listAllTheatres")
    public List<Theatre> getAllTheatres(){
        return service.getAllTheatres();
    }

}
