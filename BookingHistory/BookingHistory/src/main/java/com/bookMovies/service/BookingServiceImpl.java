package com.bookMovies.service;

import com.bookMovies.client.MoviesServiceFeign;
import com.bookMovies.client.TheatreServiceFeign;
import com.bookMovies.client.UserServiceFeign;
import com.bookMovies.configuration.JwtService;
import com.bookMovies.dto.Booking;
import com.bookMovies.dto.MovieDetails;
import com.bookMovies.dto.TheatreDetails;
import com.bookMovies.exception.MovieIdDoesNotExistException;
import com.bookMovies.exception.TheatreIdDoesNotExistException;
import com.bookMovies.repository.BookingRepository;
import com.bookMovies.model.BookingHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository repository;

    @Autowired
    private MoviesServiceFeign moviesServiceFeign;

    @Autowired
    private TheatreServiceFeign theatreServiceFeign;

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    public BookingHistory addBooking(Booking booking)throws MovieIdDoesNotExistException, TheatreIdDoesNotExistException {
        if(moviesServiceFeign.isIdExist(booking.getMovieId())){
            throw new MovieIdDoesNotExistException("Movie ID provided is wrong");
        }
        if(theatreServiceFeign.isIdExist(booking.getTheatreId())){
            throw new TheatreIdDoesNotExistException("Theatre ID provided is wrong");
        }
        MovieDetails movieDetails=moviesServiceFeign.details(booking.getMovieId());
        TheatreDetails theatreDetails=theatreServiceFeign.details(booking.getTheatreId());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Long id = userServiceFeign.getUserId(username);


        BookingHistory bookingHistory=new BookingHistory(id,movieDetails.getTitle(),theatreDetails.getName(),
                theatreDetails.getAddress(), booking.getSeatsBooked(), movieDetails.getCertificate(),
                    booking.getShowTime(),booking.getShowDate(), LocalDateTime.now());

        return repository.save(bookingHistory);
    }
}
