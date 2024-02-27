package com.example.movie.reservation.service;

import com.example.movie.reservation.repository.MemberRepository;
import com.example.movie.reservation.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;
    private final MemberRepository memberRepository;

    /**
     * 관리자 권한 확인 후 등록 가능하도록
     */
    public void save() {};
    public void delete() {};
}
