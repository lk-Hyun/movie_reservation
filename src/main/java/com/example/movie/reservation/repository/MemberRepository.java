package com.example.movie.reservation.repository;

import com.example.movie.reservation.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public boolean existsByEmail(String email);
    public Member findByEmail(String email);
}
