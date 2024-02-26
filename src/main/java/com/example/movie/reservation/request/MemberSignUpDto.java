package com.example.movie.reservation.request;

import com.example.movie.reservation.domain.Member;
import com.example.movie.reservation.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MemberSignUpDto(
        @Email String email,
        @NotNull @Size(min = 4, max = 15) String password,
        @NotNull @Size(min = 4, max = 15) String name,
        @NotNull @Size(min = 11, max = 15) String phoneNum
) {
    /**
     * 새로운 기능 추가될 때마다 new ArrayList<>() 를 통해 빈 객체를 생성해줘야 한다
     */
    public Member toEntity() {
        return Member.builder()
                .email(email).password(password).name(name).phoneNum(phoneNum)
                .role(Role.USER).build();
    }
}
