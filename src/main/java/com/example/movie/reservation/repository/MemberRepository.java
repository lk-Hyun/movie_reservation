package com.example.movie.reservation.repository;

import com.example.movie.reservation.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
