package com.codebuilder.relationship.repository;

import com.codebuilder.relationship.model.manytomany.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByNameContaining(String name);
}