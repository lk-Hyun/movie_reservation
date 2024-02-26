package com.example.movie.reservation.repository;

import com.example.movie.reservation.domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
