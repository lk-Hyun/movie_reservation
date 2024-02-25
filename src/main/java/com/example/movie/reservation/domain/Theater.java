package com.example.movie.reservation.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Theater {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    @OneToMany(mappedBy = "theater")
    private List<Screening> screenings;

    private String name;
    private Long seatCount;
}
