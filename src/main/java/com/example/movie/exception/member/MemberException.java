package com.example.movie.exception.member;

import com.example.movie.exception.BaseException;
import com.example.movie.exception.BaseExceptionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberException extends BaseException {

    private final BaseExceptionType exceptionType;
}
