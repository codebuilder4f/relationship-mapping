package com.codebuilder.relationship.repository;

import com.codebuilder.relationship.model.manytomany.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findByTitleContaining(String title);

    List<Course> findByFeeLessThan(double fee);
}