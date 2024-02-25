package com.example.movie.reservation.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String title;
    private String director;
    private String genre;
    private String rating;
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private List<Screening> screenings;
}


