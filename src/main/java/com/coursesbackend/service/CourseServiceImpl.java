package com.coursesbackend.service;

import com.coursesbackend.entity.Course;
import com.coursesbackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return courses;
    }

    @Override
    public Course addSingleCourse(Course course) {
        Course courseReturned = courseRepository.save(course);
        return courseReturned;
    }

    @Override
    public String deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
        return "Course Deleted !";
    }
}
