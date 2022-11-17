package com.codebuilder.relationship;

import com.codebuilder.relationship.model.manytomany.Course;
import com.codebuilder.relationship.model.manytomany.Student;
import com.codebuilder.relationship.repository.CourseRepository;
import com.codebuilder.relationship.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RelationshipMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationshipMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(StudentRepository studentRepository,
                                         CourseRepository courseRepository) {
        return args -> {

            // create a student
            Student student1 = new Student("John Doe", 15, "8th");
            Student student2 = new Student("Kamila Doe", 15, "8th");
            Student student3 = new Student("Fedrik Doe", 15, "8th");

            // save the student
            studentRepository.saveAll(Arrays.asList(student1, student2, student3));

            // create three courses
            Course course1 = new Course("Machine Learning", "ML", 12, 1500);
            Course course2 = new Course("Database Systems", "DS", 8, 800);
            Course course3 = new Course("Web Basics", "WB", 10, 0);


            // save courses
            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            // add courses to the student
            student1.getCourses().addAll(Arrays.asList(course1, course2, course3));
            student2.getCourses().addAll(Arrays.asList(course1, course2, course3));
            student3.getCourses().addAll(Arrays.asList(course1, course2, course3));

            course1.getStudents().addAll(Arrays.asList(student1, student2,student3));
            course2.getStudents().addAll(Arrays.asList(student1, student2,student3));
            course3.getStudents().addAll(Arrays.asList(student1, student2,student3));

            // update the student
            studentRepository.saveAll(Arrays.asList(student1,student2,student3));
            courseRepository.saveAll(Arrays.asList(course1,course2,course3));
        };
    }

}
