package com.example.movielibrary.controller;

import com.example.movielibrary.classes.PagedRecords;
import com.example.movielibrary.classes.Pager;
import com.example.movielibrary.classes.PagingParams;
import com.example.movielibrary.dto.MovieDto;
import com.example.movielibrary.entity.Movie;
import com.example.movielibrary.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AppController {
    private final MovieService movieService;

    public AppController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/error")
    public String error() {
        return "error/error";
    }

    @GetMapping("/")
    public String homepage(@RequestParam(name = "page", required = false, defaultValue = "1") int page, Model model) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            model.addAttribute("date", simpleDateFormat.format(new Date()));

            int pageSize = 10;

            PagedRecords<Movie, MovieDto> movies = movieService.getMovies(new PagingParams(page, pageSize));
            model.addAttribute("movies", movies.getRecordsDto());

            Pager pager = new Pager(page, pageSize, movies.getTotal());
            model.addAttribute("pager", pager);

            return "homepage/homepage";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error/exception";
        }
    }
}
