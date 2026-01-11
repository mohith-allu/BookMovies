package com.bookMovies.client;

import com.bookMovies.dto.TheatreDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "theatre-service",path = "/api/theatre")
public interface TheatreServiceFeign {
    @GetMapping("/exists/{id}")
    boolean isIdExist(@PathVariable("id") Long id);

    @GetMapping("/getDetails/{id}")
    TheatreDetails details(@PathVariable("id") Long id);
}
