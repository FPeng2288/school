package com.fpeng2288.school.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Student
 * Package: com.fpeng2288.school.model
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 22:32
 * @version 1.0
 */
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String grade;

    @JsonManagedReference("student-teachers")
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentTeacher> studentTeachers = new ArrayList<>();

    // Custom toString to prevent infinite recursion
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }
}
