package com.fpeng2288.school.service;

import com.fpeng2288.school.dto.StudentDTO;
import com.fpeng2288.school.dto.TeacherDTO;
import com.fpeng2288.school.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: StudentService
 * Package: com.fpeng2288.school.service
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:31
 * @version 1.0
 */
public interface StudentService {

    List<StudentDTO> findAllStudents();

    List<StudentDTO> findStudentsByAgeRange(int minAge, int maxAge);

    Optional<StudentDTO> findStudentById(Long id);

    StudentDTO saveStudent(Student student);

    void deleteStudent(Long id);

    List<TeacherDTO> findTeachersByStudentId(Long studentId);
}
