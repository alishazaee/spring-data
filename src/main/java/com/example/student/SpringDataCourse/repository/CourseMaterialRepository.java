package com.example.student.SpringDataCourse.repository;

import com.example.student.SpringDataCourse.entity.CourseMaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMaterialRepository extends CrudRepository<CourseMaterial,Long> {

    @Override
    List<CourseMaterial> findAll();
}
