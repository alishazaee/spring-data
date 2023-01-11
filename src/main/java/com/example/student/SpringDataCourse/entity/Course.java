package com.example.student.SpringDataCourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue
    private long courseId;
    private String title;
    private Integer credit;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @OneToOne(
            mappedBy = "course",
            cascade = CascadeType.ALL
    )
    private CourseMaterial courseMaterial;

    @ManyToMany(
            mappedBy = "courseList",
            cascade = CascadeType.ALL
    )
    private List<Student> studentList;

}
