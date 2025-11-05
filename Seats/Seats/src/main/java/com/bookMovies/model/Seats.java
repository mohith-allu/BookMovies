package com.bookMovies.model;

import jakarta.persistence.*;

@Entity
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long theatreId;
    private int screenNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private int totalSeats;
    private int price;

    public Seats() {
    }

    public Seats(Long id, Long theatreId, int screenNumber, SeatType seatType, int totalSeats, int price) {
        this.id = id;
        this.theatreId = theatreId;
        this.screenNumber = screenNumber;
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.price = price;
    }

    public Seats(Long theatreId, int screenNumber, SeatType seatType, int totalSeats, int price) {
        this.theatreId = theatreId;
        this.screenNumber = screenNumber;
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
