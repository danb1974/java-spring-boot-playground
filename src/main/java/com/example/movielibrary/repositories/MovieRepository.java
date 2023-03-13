package com.example.movielibrary.repositories;

import com.example.movielibrary.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Page<Movie> findAllByRented(Pageable pageable, boolean rented);

//    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) = LOWER(:title)")
//    public abstract Movie retrieveByName(@Param("title") String title);
}
