package com.bookMovies.client;

import com.bookMovies.dto.SeatsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="seats-service",path="/api/seats")
public interface SeatsServiceFeign {
    @GetMapping("/{theatreId}/{screenNumber}")
    List<SeatsRequest> getSeatsByTheatreIdAndScreenNumber(
            @PathVariable("theatreId") Long theatreId, @PathVariable("screenNumber") int screenNumber);
}
