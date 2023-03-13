package com.example.movielibrary.classes.mappers;

import com.example.movielibrary.dtos.MovieDto;
import com.example.movielibrary.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class ListEntityToDtoMapper {
    public static List<MovieDto> movieToMovieDto(List<Movie> movies) throws Exception {
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie: movies) {
            movieDtos.add(new MovieDto(movie));
        }

        return movieDtos;
    }
}
