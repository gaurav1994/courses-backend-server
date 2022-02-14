package com.coursesbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

@ControllerAdvice
public class CustomExceptionHandling {

    @ExceptionHandler(CourseExistException.class)
    public ResponseEntity<?> handleCourseExistException(CourseExistException ex, ServletWebRequest swr){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(API_ERRORS.builder().message(ex.getMessage()).build() );
    }
}
