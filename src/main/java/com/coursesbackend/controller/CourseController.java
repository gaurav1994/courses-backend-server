package com.coursesbackend.controller;

import com.coursesbackend.entity.Course;
import com.coursesbackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/all-courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> allCourses = courseService.getAllCourses();
        return ResponseEntity.status(HttpStatus.OK).body(allCourses);
    }

    @PostMapping("/save-course")
    public ResponseEntity<Course> saveSingleCourse(@RequestBody Course course){
        Course course1 = courseService.addSingleCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(course1);
    }


    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deleteCourseByCourseId(@PathVariable Long courseId){
        String deleteMessage = courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(deleteMessage);
    }
}
