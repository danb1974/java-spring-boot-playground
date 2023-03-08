package com.example.movielibrary.controller;

import com.example.movielibrary.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AppController {
    MovieService movieService;

    public AppController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("date", simpleDateFormat.format(new Date()));

        model.addAttribute("movies", movieService.getAllMovies());

        return "homepage/homepage";
    }
}
