package com.bookMovies.service;

import com.bookMovies.exception.EmailAlreadyExistException;
import com.bookMovies.exception.PasswordNotStrongException;
import com.bookMovies.exception.WrongCredentialsExceptions;
import com.bookMovies.model.Users;

public interface UserService {
    String loginUser(Users user) throws WrongCredentialsExceptions;
    Users registerUser(Users user) throws EmailAlreadyExistException, PasswordNotStrongException;
    boolean deleteUser(Users user) throws WrongCredentialsExceptions;
    Long getUserId(String email);
}
