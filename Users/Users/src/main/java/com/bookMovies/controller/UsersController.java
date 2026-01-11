package com.bookMovies.controller;

import com.bookMovies.exception.EmailAlreadyExistException;
import com.bookMovies.exception.PasswordNotStrongException;
import com.bookMovies.exception.WrongCredentialsExceptions;
import com.bookMovies.model.Users;
import com.bookMovies.service.JwtService;
import com.bookMovies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) throws EmailAlreadyExistException, PasswordNotStrongException {
        return service.registerUser(user);
    }

    @GetMapping("/login")
    public String loginUser(@RequestBody Users user) throws WrongCredentialsExceptions{
        return service.loginUser(user);
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestBody Users user) throws WrongCredentialsExceptions{
        return service.deleteUser(user);
    }

    @GetMapping("/getId/{email}")
    public Long getUserId(@PathVariable("email") String email){
        return service.getUserId(email);
    }

}
