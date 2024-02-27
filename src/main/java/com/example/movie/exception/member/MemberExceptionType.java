package com.example.movie.exception.member;

import com.example.movie.exception.BaseExceptionType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum MemberExceptionType implements BaseExceptionType {

    NOT_FOUND_MEMBER(600, HttpStatus.OK, "사용자를 찾을 수 없습니다."),
    ALREADY_EXIST_EMAIL(601, HttpStatus.OK, "이미 존재하는 아이디입니다."),
    WRONG_PASSWORD(602, HttpStatus.OK, "잘못된 비밀번호입니다."),
    PASSWORD_NOT_EQUAL(603, HttpStatus.OK, "비밀번호가 일치하지 않습니다.");

    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String errorMessage;

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
