package com.example.movielibrary.dtos;

import com.example.movielibrary.entities.Movie;

import java.time.format.DateTimeFormatter;

public class MovieDto extends BaseDto {
    private String title;

    private String date;

    private boolean rented;

    private String directorFullName;

    public MovieDto(Movie movie) throws Exception {
        super(movie.getId());

        copyProperties(movie, this, "title", "rented");
        setDate(movie.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        setDirectorFullName(movie.getDirector().getFullName());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getDirectorFullName() {
        return directorFullName;
    }

    public void setDirectorFullName(String directorFullName) {
        this.directorFullName = directorFullName;
    }

    public MovieDto(long id) {
        super(id);
    }
}
