package com.example.movielibrary.entity;

import com.example.movielibrary.dto.BaseDto;
import com.example.movielibrary.dto.MovieDto;
import com.example.movielibrary.interfaces.IDtoEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "movies")
public class Movie implements IDtoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private LocalDate date;

    private boolean rented;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    protected Movie() {
    }

    public Movie(String title, LocalDate date, Director director) {
        this.title = title;
        this.date = date;
        this.director = director;
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

    public void setTitle(String name) {
        this.title = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public MovieDto toDto() throws Exception {
        MovieDto dto = new MovieDto(this.id);

        dto.copyProperties(this, dto, "title");
        dto.setDate(this.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        dto.setDirectorFullName(this.getDirector().getFullName());

        return dto;
    }
}
