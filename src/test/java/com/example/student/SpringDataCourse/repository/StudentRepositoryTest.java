package com.example.student.SpringDataCourse.repository;

import com.example.student.SpringDataCourse.entity.Course;
import com.example.student.SpringDataCourse.entity.CourseMaterial;
import com.example.student.SpringDataCourse.entity.Guardian;
import com.example.student.SpringDataCourse.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest  // Doesn't affect the DB
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;



    @Test
    public void addStudent(){
        CourseMaterial DSmaterial = CourseMaterial.builder()
                .url("ds.com")
                .build();
        CourseMaterial AImaterial = CourseMaterial.builder()
                .url("ai.com")
                .build();

        CourseMaterial Compilermaterial = CourseMaterial.builder()
                .url("compiler.com")
                .build();
        //////
        Course DSCourse = Course.builder()
                .credit(10)
                .courseMaterial(DSmaterial)
                .title("DS")
                .build();
        Course AICourse = Course.builder()
                .credit(20)
                .courseMaterial(AImaterial)
                .title("AI")
                .build();

        Course CompilerCourse = Course.builder()
                .credit(20)
                .title("Compiler")
                .courseMaterial(Compilermaterial)
                .build();
        DSmaterial.setCourse(DSCourse);
        AImaterial.setCourse(AICourse);
        Compilermaterial.setCourse(CompilerCourse);
        //////
        Guardian guardian = Guardian.builder()
                .mobile("091222")
                .name("sample Guard")
                .email("guard@gmail.com")
                .build();
        Student ali = Student.builder()
                .firstname("ali")
                .lastname("shazaei")
                .emailId("a.com")
                .guardian(guardian)
                .courseList(List.of(CompilerCourse, AICourse))
                .build();
        Student erfan = Student.builder()
                .firstname("erfan")
                .lastname("shazaei")
                .emailId("e.com")
                .guardian(guardian)
                .courseList(List.of(DSCourse, AICourse))
                .build();
        studentRepository.save(ali);
    }

}