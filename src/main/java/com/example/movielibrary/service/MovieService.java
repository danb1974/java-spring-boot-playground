package com.example.movielibrary.service;

import com.example.movielibrary.classes.PagedRecords;
import com.example.movielibrary.classes.PagingParams;
import com.example.movielibrary.dto.MovieDto;
import com.example.movielibrary.entity.Movie;
import com.example.movielibrary.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public PagedRecords<Movie, MovieDto> getMovies(PagingParams pagingParams) {
        Sort sort = getDefaultSort();
        Page<Movie> page = movieRepository.findAll(pagingParams.getPageable(sort));
        return new PagedRecords<>(page);
    }

    private Sort getDefaultSort() {
        return Sort.by(Sort.Direction.DESC, "date");
    }
}
