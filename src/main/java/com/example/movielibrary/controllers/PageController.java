package com.example.movielibrary.controllers;

import com.example.movielibrary.classes.PagedRecords;
import com.example.movielibrary.classes.Pager;
import com.example.movielibrary.classes.PagingParams;
import com.example.movielibrary.classes.mappers.ListEntityToDtoMapper;
import com.example.movielibrary.dtos.MovieDto;
import com.example.movielibrary.entities.Movie;
import com.example.movielibrary.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PageController {
    private final MovieService movieService;

    public PageController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/error")
    public String error() {
        return "error/error";
    }

    @GetMapping("/")
    public String movieList(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "filter", required = false, defaultValue = "all") String filter,
            Model model
    ) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            model.addAttribute("date", simpleDateFormat.format(new Date()));

            model.addAttribute("rented", filter.equals("rented"));

            int pageSize = 10;

            PagedRecords<Movie> movies = movieService.getMoviesPaged(new PagingParams(page, pageSize), filter.equals("rented"));
            model.addAttribute("movies", ListEntityToDtoMapper.entityListToDtoList(movies.getRecords(), Movie.class, MovieDto.class));

            Pager pager = new Pager(page, pageSize, movies.getTotal());
            model.addAttribute("pager", pager);

            return "homepage/homepage";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error/exception";
        }
    }
}
