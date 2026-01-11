package com.bookMovies.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private Long movieId;
    private Long theatreId;
    private LocalTime showTime;
    private LocalDate showDate;
    private int seatsBooked;

    public Booking() {
    }

    public Booking(Long movieId, Long theatreId, LocalTime showTime, LocalDate showDate, int seatsBooked) {
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.showTime = showTime;
        this.showDate = showDate;
        this.seatsBooked = seatsBooked;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }
}
