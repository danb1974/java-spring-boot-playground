package com.example.movielibrary.services;

import com.example.movielibrary.classes.PagedRecords;
import com.example.movielibrary.classes.PagingParams;
import com.example.movielibrary.entities.Movie;
import com.example.movielibrary.exceptions.NoSuchMovieException;
import com.example.movielibrary.repositories.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public PagedRecords<Movie> getMoviesPaged(PagingParams pagingParams) {
        return getMoviesPaged(pagingParams, false);
    }

    public PagedRecords<Movie> getMoviesPaged(PagingParams pagingParams, boolean onlyRented) {
        Sort sort = getDefaultSort();
        Pageable pageable = pagingParams.getPageable(sort);
        Page<Movie> page = onlyRented ? movieRepository.findAllByRented(pageable, true) : movieRepository.findAll(pageable);
        return new PagedRecords<>(page);
    }

    public Movie rentMovie(long movieId) throws Exception {
        Movie movie = movieRepository.findById(movieId).orElseThrow(NoSuchMovieException::new);

        movie.setRented(true);
        movieRepository.save(movie);

        return movie;
    }

    public Movie returnMovie(long movieId) throws Exception {
        Movie movie = movieRepository.findById(movieId).orElseThrow(NoSuchMovieException::new);

        movie.setRented(false);
        movieRepository.save(movie);

        return movie;
    }

    private Sort getDefaultSort() {
        return Sort.by(Sort.Direction.DESC, "date");
    }
}
