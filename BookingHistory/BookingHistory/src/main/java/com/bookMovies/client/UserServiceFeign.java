package com.bookMovies.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="users-service",path = "/api/users")
public interface UserServiceFeign {
    @GetMapping("/getId/{email}")
    Long getUserId(@PathVariable("email") String email);
}
