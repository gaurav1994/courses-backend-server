package com.coursesbackend.service;

import com.coursesbackend.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course addSingleCourse(Course course);
    String deleteCourse(Long courseId);
}
