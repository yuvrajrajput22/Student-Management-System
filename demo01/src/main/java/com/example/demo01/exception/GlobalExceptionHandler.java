package com.example.demo01.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException e) {
        return "please provide id";
    }

    @ExceptionHandler(Exception.class)
    public String handleRuntimeException(Exception e)
    {
        return e.getMessage();
    }
}