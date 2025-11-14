package com.bookMovies.dto;

import com.bookMovies.model.SeatType;

public class SeatsRequest {
    private SeatType seatType;
    private int totalSeats;
    private int price;

    public SeatsRequest(SeatType seatType, int totalSeats, int price) {
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.price = price;
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
