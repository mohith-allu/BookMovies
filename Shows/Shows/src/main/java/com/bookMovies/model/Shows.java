package com.bookMovies.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long movieId;
    private Long theatreId;
    private LocalTime showTime;
    private LocalDate showDate;
    private int screenNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "showId",referencedColumnName = "id")
    private List<ShowSeats> showSeats;

    public Shows() {
    }

    public Shows(Long id, Long movieId, Long theatreId, LocalTime showTime, LocalDate showDate, int screenNumber) {
        this.id = id;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.showTime = showTime;
        this.showDate = showDate;
        this.screenNumber = screenNumber;
    }

    public Shows(Long movieId, Long theatreId, LocalTime showTime, LocalDate showDate, int screenNumber) {
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.showTime = showTime;
        this.showDate = showDate;
        this.screenNumber = screenNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }


}
