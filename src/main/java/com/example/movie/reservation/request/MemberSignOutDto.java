package com.example.movie.reservation.request;

import com.example.movie.reservation.domain.Member;
import com.example.movie.reservation.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MemberSignOutDto (
    //이메일 pw pw
    @Email String email,

    @NotNull @Size(min = 8, max = 15, message = "비밀번호는 최소 8글자 이상 최대 16글자 이하로 작성해야 합니다.")
    String password,

    @NotNull @Size(min = 8, max = 15)
    String cPassword,

    @NotNull @Size(min = 8, max = 15,  message = "비밀번호는 최소 8글자 이상 최대 16글자 이하로 작성해야 합니다.")
    String rawPassword

)
{

}
