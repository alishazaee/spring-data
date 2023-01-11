package com.example.student.SpringDataCourse.repository;

import com.example.student.SpringDataCourse.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student , Long> {

    List<Student> findAllByLastnameContaining(String name);
    Student findByEmailId(String email);



}
