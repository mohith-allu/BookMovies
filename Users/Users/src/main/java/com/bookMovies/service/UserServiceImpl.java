package com.bookMovies.service;

import com.bookMovies.exception.EmailAlreadyExistException;
import com.bookMovies.exception.PasswordNotStrongException;
import com.bookMovies.exception.WrongCredentialsExceptions;
import com.bookMovies.model.Users;
import com.bookMovies.repository.UsersRepository;
import com.bookMovies.validator.PasswordValidator;
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
    public Users registerUser(Users user) throws EmailAlreadyExistException, PasswordNotStrongException {
        if(repository.existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistException("Email already taken");
        }
        if(!PasswordValidator.passwordValidator(user.getPassword())){
            throw new PasswordNotStrongException("Password must be between 8-12 character" +
                                                 "It must contain atleast one uppercase character" +
                                                 "It must contain atleast one lowercase character" +
                                                 "It must contain atleast one numerical" +
                                                 "It must contain atleast one special character");
        }

        return repository.save(user);
    }

    @Override
    public boolean deleteUser(Users user) throws WrongCredentialsExceptions {
        if(!repository.existsByEmailAndPassword(user.getEmail(), user.getPassword())){
            throw new WrongCredentialsExceptions("Entered credentials are wrong");
        }
        repository.deleteById(repository.findIdByEmail(user.getEmail()));
        return true;
    }
}
