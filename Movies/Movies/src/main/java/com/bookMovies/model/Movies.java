package com.bookMovies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private int duration;
    private Double rating;
    private String certificate;
    private String langusge;

    public Movies() {
    }

    public Movies(Long id, String title, String genre, int duration, Double rating, String certificate, String langusge) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.certificate = certificate;
        this.langusge = langusge;
    }

    public Movies(String title, String genre, int duration, Double rating, String certificate, String langusge) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.certificate = certificate;
        this.langusge = langusge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getLangusge() {
        return langusge;
    }

    public void setLangusge(String langusge) {
        this.langusge = langusge;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                ", certificate='" + certificate + '\'' +
                ", langusge='" + langusge + '\'' +
                '}';
    }
}
