package com.micro.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> userExceptionHandler(UserException ex, WebRequest request){

        ErrorDetails err = ErrorDetails
                .builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .uri(request.getDescription(false))
                .build();

        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> exceptionHandler(Exception ex, WebRequest request){

        ErrorDetails err = ErrorDetails
                .builder()
                .timestamp(LocalDateTime.now())
                .message("Default exception handler used")
                .uri(request.getDescription(false))
                .build();

        return ResponseEntity.internalServerError().body(err);
    }
}
