package com.example.movie.reservation.repository;

import com.example.movie.reservation.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
