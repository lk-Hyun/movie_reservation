package com.example.movie.exception;

import org.springframework.http.HttpStatus;

public interface BaseExceptionType {

    int getErrorCode();

    HttpStatus getHttpStatus();

    String getErrorMessage();
}
