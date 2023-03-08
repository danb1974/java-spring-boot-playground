package com.example.movielibrary.service;

import com.example.movielibrary.classes.PagedResult;
import com.example.movielibrary.classes.PagingParams;
import com.example.movielibrary.entity.Movie;
import com.example.movielibrary.repository.MovieRepository;
import org.springframework.data.domain.Page;
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
        Sort sort = getDefaultSort();
        return movieRepository.findAll(sort);
    }

    public PagedResult<Movie> getMovies(PagingParams pagingParams) {
        Sort sort = getDefaultSort();
        Page<Movie> page = movieRepository.findAll(pagingParams.getPageable(sort));
        return new PagedResult<Movie>(page);
    }

    private Sort getDefaultSort() {
        return Sort.by(Sort.Direction.DESC, "date");
    }
}
