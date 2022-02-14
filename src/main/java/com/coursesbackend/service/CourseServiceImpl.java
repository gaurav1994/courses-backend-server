package com.coursesbackend.service;

import com.coursesbackend.entity.Course;
import com.coursesbackend.exception.CourseExistException;
import com.coursesbackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public Course getSingleCourse(Long id) throws CourseExistException{
        Course course = courseRepository.findById(id).get();
        if(course == null){
            throw new CourseExistException("Course not found");
        }
        return course;
    }

    @Override
    public Course addSingleCourse(Course course) throws CourseExistException {

        try{
            courseRepository.findById(course.getId()).get();
            throw new CourseExistException("Course Already Exist");
        }catch (NoSuchElementException ex){
            Course courseReturned = courseRepository.save(course);
            return courseReturned;
        }
    }

    @Override
    public Course updateSingleCourse(Course course, Long id) throws CourseExistException {
        Course courseFetching = courseRepository.findById(id).get();
        if(courseFetching == null){
            throw new CourseExistException("Course not found");
        }
        courseFetching.setTitle(course.getTitle());
        courseFetching.setDescription(course.getDescription());
        courseFetching.setFees(course.getFees());
        Course savedCourse = courseRepository.save(courseFetching);
        return savedCourse;
    }

    @Override
    public String deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
        return "Course Deleted !";
    }
}
