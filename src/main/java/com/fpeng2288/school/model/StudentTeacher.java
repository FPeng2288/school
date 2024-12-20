package com.fpeng2288.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: StudentTeacher
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
@Table(name = "student_teacher")
public class StudentTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference("student-teachers")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @JsonBackReference("teacher-students")
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // Custom toString to prevent infinite recursion
    @Override
    public String toString() {
        return "StudentTeacher{" +
                "id=" + id +
                ", studentId=" + (student != null ? student.getId() : null) +
                ", teacherId=" + (teacher != null ? teacher.getId() : null) +
                '}';
    }
}
