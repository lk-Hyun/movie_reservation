package com.example.movie.exception;

public abstract class BaseException extends RuntimeException {

    public abstract BaseExceptionType getExceptionType();
}