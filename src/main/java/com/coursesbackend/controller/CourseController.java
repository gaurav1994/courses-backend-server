package com.coursesbackend.controller;

import com.coursesbackend.entity.Course;
import com.coursesbackend.exception.CourseExistException;
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

    @GetMapping("/all-courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) throws CourseExistException{
        Course singleCourse = courseService.getSingleCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body(singleCourse);
    }

    @PostMapping("/save-course")
    public ResponseEntity<Course> saveSingleCourse(@RequestBody Course course) throws CourseExistException {
        Course course1 = courseService.addSingleCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(course1);
    }

    @PutMapping("/update-course/{id}")
    public ResponseEntity<Course> updateSingleCourse(@RequestBody Course course, @PathVariable Long id) throws CourseExistException{
        Course updatedCourse = courseService.updateSingleCourse(course, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCourse);
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deleteCourseByCourseId(@PathVariable Long courseId){
        String deleteMessage = courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(deleteMessage);
    }
}
