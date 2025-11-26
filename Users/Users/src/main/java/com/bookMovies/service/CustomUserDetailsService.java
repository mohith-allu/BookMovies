package com.bookMovies.service;

import com.bookMovies.configuration.CustomUserDetails;
import com.bookMovies.model.Users;
import com.bookMovies.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        Users user=repository.findByEmail(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("wrong user name");
        }

        return new CustomUserDetails(user);
    }
}
