package com.bookMovies.dto;

public class MovieDetails {
    private String title;
    private String certificate;

    public MovieDetails(String title, String certificate) {
        this.title = title;
        this.certificate = certificate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
