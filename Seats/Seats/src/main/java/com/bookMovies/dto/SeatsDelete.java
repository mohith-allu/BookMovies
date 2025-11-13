package com.bookMovies.dto;

public class SeatsDelete {
    private Long theatreId;
    private int screenNumber;

    public SeatsDelete(Long theatreId, int screenNumber) {
        this.theatreId = theatreId;
        this.screenNumber = screenNumber;
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
}
