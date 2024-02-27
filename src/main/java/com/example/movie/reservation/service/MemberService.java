package com.example.movie.reservation.service;

import com.example.movie.reservation.domain.Member;
import com.example.movie.reservation.repository.MemberRepository;
import com.example.movie.reservation.request.MemberSignOutDto;
import com.example.movie.reservation.request.MemberSignUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(MemberSignUpDto dto) throws Exception {
        if (memberRepository.existsByEmail(dto.email())) {
            throw new Exception("Member Email is already Exists");
        }

        Member member = dto.toEntity();
        member.encodePassword(passwordEncoder);

        memberRepository.save(member);
    };

    public void signOut() {};

    public boolean changePassword(MemberSignOutDto dto) throws Exception {
        Member member = memberRepository.findByEmail(dto.email());

        if (!dto.password().equals(dto.cPassword())) {
            throw new Exception("password is not equals");
        }

        if (member.getPassword().equals(passwordEncoder.encode(dto.password()))) {
            member.updatePassword(passwordEncoder, dto.rawPassword());
        }

        return true;
    };

    public Member getMember(Long id) { return memberRepository.findById(id).get(); };
}
