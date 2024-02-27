package com.example.movie.reservation.service;

import com.example.movie.exception.member.MemberException;
import com.example.movie.exception.member.MemberExceptionType;
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

    public void join(MemberSignUpDto dto) {
        if (memberRepository.existsByEmail(dto.email())) {
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_EMAIL);
        }

        Member member = dto.toEntity();
        member.encodePassword(passwordEncoder);

        memberRepository.save(member);
    };

   //탈퇴
    public void signOut(MemberSignOutDto dto) throws Exception {
        Member member = memberRepository.findByEmail(dto.email());

        if(!dto.password().equals(dto.cPassword())){
            throw new MemberException(MemberExceptionType.PASSWORD_NOT_EQUAL);
        }
        if(!member.getPassword().equals(passwordEncoder.encode(dto.password()))){
            throw new MemberException(MemberExceptionType.WRONG_PASSWORD);
        }

        memberRepository.delete(member);
    };

    public boolean changePassword(MemberSignOutDto dto) throws Exception {
        Member member = memberRepository.findByEmail(dto.email());

        if(!dto.password().equals(dto.cPassword())){
            throw new MemberException(MemberExceptionType.PASSWORD_NOT_EQUAL);
        }
        if(!member.getPassword().equals(passwordEncoder.encode(dto.password()))){
            throw new MemberException(MemberExceptionType.WRONG_PASSWORD);
        }

        member.updatePassword(passwordEncoder, dto.rawPassword());

        return true;
    };

    public Member getMember(Long id) { return memberRepository.findById(id).get(); };
}
