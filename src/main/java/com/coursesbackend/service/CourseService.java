package com.coursesbackend.service;

import com.coursesbackend.entity.Course;
import com.coursesbackend.exception.CourseExistException;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course getSingleCourse(Long id) throws CourseExistException;
    Course addSingleCourse(Course course) throws CourseExistException;
    Course updateSingleCourse(Course course, Long id)throws CourseExistException;
    String deleteCourse(Long courseId);
}
