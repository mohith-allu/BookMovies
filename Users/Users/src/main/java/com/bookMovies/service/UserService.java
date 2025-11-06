package com.bookMovies.service;

import com.bookMovies.exception.EmailAlreadyExistException;
import com.bookMovies.exception.WrongCredentialsExceptions;
import com.bookMovies.model.Users;

public interface UserService {
    boolean loginUser(Users user) throws WrongCredentialsExceptions;
    void registerUser(Users user) throws EmailAlreadyExistException;
    void deleteUser(Users user) throws WrongCredentialsExceptions;
}
