package com.coursesbackend.exception;

public class CourseExistException extends Exception {
    public CourseExistException() {
        super();
    }

    public CourseExistException(String message) {
        super(message);
    }
}
