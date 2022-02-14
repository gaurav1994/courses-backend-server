package com.coursesbackend;

import com.coursesbackend.entity.Course;
import com.coursesbackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CoursesBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoursesBackendApplication.class, args);
	}

	@Autowired
	CourseRepository courseRepository;

	@Override
	public void run(String... args)  {
		Course course1 = Course.builder()
								 .id(1L)
								 .title("Core Java")
								 .description("this is our best course for learning the core java")
								 .fees(7500).build();
		Course course2 = Course.builder()
				.id(2L)
				.title("Python")
				.description("this is our best course for learning the python")
				.fees(4000).build();
		Course course3 = Course.builder()
				.id(3L)
				.title("Spring Boot")
				.description("this is our best course for learning the Spring Boot")
				.fees(6500).build();
		Course course4 = Course.builder()
				.id(4L)
				.title("Angular")
				.description("this is our best course for learning the Angular")
				.fees(4000).build();

		courseRepository.saveAll(Arrays.asList(course1,course2,course3,course4));
	}
}
