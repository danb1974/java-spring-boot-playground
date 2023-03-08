package com.example.movielibrary.dto;

public class MovieDto extends BaseDto {
    private String title;

    private String date;

    private String directorFullName;

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
