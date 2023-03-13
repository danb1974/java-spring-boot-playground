package com.example.movielibrary.controllers;

import com.example.movielibrary.dtos.MovieDto;
import com.example.movielibrary.entities.Movie;
import com.example.movielibrary.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class FragmentController {
    private final MovieService movieService;

    public FragmentController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/fragments/movie/rent")
    public String rentMovie(@RequestParam(name = "movieId") int movieId, Model model) throws Exception {
        Movie movie = movieService.rentMovie(movieId);

        model.addAllAttributes(new HashMap<>() {{
            put("rented", false);
            put("movie", new MovieDto(movie));
        }});

        return "fragments/movie";
    }

    @PostMapping("/fragments/movie/return")
    public String returnMovie(@RequestParam(name = "movieId") int movieId, Model model) throws Exception {
        Movie movie = movieService.returnMovie(movieId);

        model.addAllAttributes(new HashMap<>() {{
            put("rented", true);
            put("movie", new MovieDto(movie));
        }});

        return "fragments/movie";
    }
}
