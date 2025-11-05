package com.bookMovies.model;

import jakarta.persistence.*;

@Entity
public class ShowSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long showId;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private int availableSeats;
    private int price;

    public ShowSeats() {
    }

    public ShowSeats(Long id, Long showId, SeatType seatType, int availableSeats, int price) {
        this.id = id;
        this.showId = showId;
        this.seatType = seatType;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    public ShowSeats(Long showId, SeatType seatType, int availableSeats, int price) {
        this.showId = showId;
        this.seatType = seatType;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShowSeats{" +
                "id=" + id +
                ", showId=" + showId +
                ", seatType=" + seatType +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                '}';
    }
}
