package com.bookMovies.service;

import com.bookMovies.exception.EmailAlreadyExistException;
import com.bookMovies.exception.WrongCredentialsExceptions;
import com.bookMovies.model.Users;
import com.bookMovies.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository repository;

    @Override
    public boolean loginUser(Users user) throws WrongCredentialsExceptions {
        if(!repository.existsByEmailAndPassword(user.getEmail(), user.getPassword())){
            throw new WrongCredentialsExceptions("Entered credentials are wrong");
        }
        return true;
    }

    @Override
    public void registerUser(Users user) throws EmailAlreadyExistException {
        if(repository.existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistException("Email already taken");
        }
        repository.save(user);
    }

    @Override
    public void deleteUser(Users user) throws WrongCredentialsExceptions {
        if(!repository.existsByEmailAndPassword(user.getEmail(), user.getPassword())){
            throw new WrongCredentialsExceptions("Entered credentials are wrong");
        }
        repository.deleteById(repository.findIdByEmail(user.getEmail()));
    }
}
