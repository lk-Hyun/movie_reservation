package com.example.movie.reservation.repository;

import com.example.movie.reservation.domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
