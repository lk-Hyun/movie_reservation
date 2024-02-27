package com.example.movie.reservation.service;

import com.example.movie.reservation.domain.Member;
import com.example.movie.reservation.domain.Role;
import com.example.movie.reservation.repository.MemberRepository;
import com.example.movie.reservation.request.MemberSignUpDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @BeforeEach
    void setup() {
        Member memberEntity = Member.builder()
                .email("haeun7700" + "@naver.com")
                .password("haeun7017")
                .name("jhe")
                .phoneNum("01012345678")
                .role(Role.USER).build();
        memberRepository.save(memberEntity);
    }

    @Test
    @DisplayName("유요한 회원 정보로 가입 성공")
    void joinSuccess() throws Exception {
        //given
        MemberSignUpDto dto = new MemberSignUpDto("haeun@naver.com", "123456789", "haeun", "010");

        memberService.join(dto);

        assertEquals("haeun", memberService.getMember(1L).getName());
    }

//    @Test
//    @DisplayName("이메일 중복 검사")
//    void () {
//        //given
//
//        //when
//
//        //then
//    }

    private void asseetThat(boolean equals) {
    }

}
/*
회원 가입:
유효한 회원 정보를 제공했을 때 회원이 성공적으로 등록되는지 확인
이미 존재하는 이메일 주소로 회원 가입 시도 시 적절한 오류가 발생하는지 확인
로그인:
올바른 이메일과 비밀번호를 제공했을 때 로그인이 성공적으로 수행되는지 확인
잘못된 이메일이나 비밀번호를 제공했을 때 로그인 시도 시 적절한 오류가 발생하는지 확인
회원 정보 조회:
존재하는 회원의 정보를 제대로 조회하는지 확인
존재하지 않는 회원의 정보 조회 시 적절한 오류가 발생하는지 확인
회원 정보 수정:
회원이 자신의 정보를 성공적으로 수정할 수 있는지 확인
다른 회원의 정보를 수정할 시도 시 적절한 권한 오류가 발생하는지 확인
회원 탈퇴:
회원이 성공적으로 탈퇴할 수 있는지 확인
이미 탈퇴한 회원이 탈퇴 시도 시 적절한 오류가 발생하는지 확인
 */
