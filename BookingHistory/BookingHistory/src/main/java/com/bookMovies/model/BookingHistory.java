package com.bookMovies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class BookingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String movieName;
    private String theatreName;
    private String theatreAddress;
    private int seatsBooked;
    private String movieCertificate;
    private LocalTime showTime;
    private LocalDate showDate;
    private LocalDateTime bookedTime;

    public BookingHistory() {
    }

    public BookingHistory(Long id, Long userId, String movieName, String theatreName, String theatreAddress, int seatsBooked, String movieCertificate, LocalTime showTime, LocalDate showDate, LocalDateTime bookedTime) {
        this.id = id;
        this.userId = userId;
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.theatreAddress = theatreAddress;
        this.seatsBooked = seatsBooked;
        this.movieCertificate = movieCertificate;
        this.showTime = showTime;
        this.showDate = showDate;
        this.bookedTime = bookedTime;
    }

    public BookingHistory(Long userId, String movieName, String theatreName, String theatreAddress, int seatsBooked, String movieCertificate, LocalTime showTime, LocalDate showDate, LocalDateTime bookedTime) {
        this.userId = userId;
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.theatreAddress = theatreAddress;
        this.seatsBooked = seatsBooked;
        this.movieCertificate = movieCertificate;
        this.showTime = showTime;
        this.showDate = showDate;
        this.bookedTime = bookedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreAddress() {
        return theatreAddress;
    }

    public void setTheatreAddress(String theatreAddress) {
        this.theatreAddress = theatreAddress;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public String getMovieCertificate() {
        return movieCertificate;
    }

    public void setMovieCertificate(String movieCertificate) {
        this.movieCertificate = movieCertificate;
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

    public LocalDateTime getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(LocalDateTime bookedTime) {
        this.bookedTime = bookedTime;
    }

    @Override
    public String toString() {
        return "BookingHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", movieName='" + movieName + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", theatreAddress='" + theatreAddress + '\'' +
                ", seatsBooked=" + seatsBooked +
                ", movieCertificate='" + movieCertificate + '\'' +
                ", showTime=" + showTime +
                ", showDate=" + showDate +
                ", bookedTime=" + bookedTime +
                '}';
    }
}
