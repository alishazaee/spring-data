package com.example.student.SpringDataCourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student" ,uniqueConstraints =
@UniqueConstraint(
        name= "emailid" ,
        columnNames =  "email_address"
)
)
public class Student {
    @Id
    @GeneratedValue
    private  long studentId;
    private String firstname;
    private String lastname;

    @Column(name = "email_address" , nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="course_id",
                    referencedColumnName = "courseId"
            )
    )
    private List<Course> courseList ;
}
