package com.bookMovies.service;

import com.bookMovies.exception.EmailAlreadyExistException;
import com.bookMovies.exception.WrongCredentialsExceptions;
import com.bookMovies.model.Users;

public interface UserService {
    boolean loginUser(Users user) throws WrongCredentialsExceptions;
    Users registerUser(Users user) throws EmailAlreadyExistException;
    boolean deleteUser(Users user) throws WrongCredentialsExceptions;
}
