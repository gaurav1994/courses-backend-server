package com.coursesbackend.repository;

import com.coursesbackend.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {

//    @Query("insert into course(id,title,fees,description) values(?1,?2,?3,?4) where id=?5")
//    Course saveCourse(Course course);
}
