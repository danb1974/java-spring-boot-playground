package com.example.movielibrary.service;

import com.example.movielibrary.entity.Movie;
import com.example.movielibrary.repository.MovieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }
}
