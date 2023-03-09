package com.example.movielibrary.repository;

import com.example.movielibrary.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Page<Movie> findAllByRented(Pageable pageable, boolean rented);
}
