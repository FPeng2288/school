package com.fpeng2288.school.dao;

import com.fpeng2288.school.model.Student;
import com.fpeng2288.school.model.Teacher;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: StudentDao
 * Package: com.fpeng2288.school.dao
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:22
 * @version 1.0
 */
public interface StudentDao {

    List<Student> findAll();

    List<Student> findByAgeRange(int minAge, int maxAge);

    Optional<Student> findById(Long id);

    Student save(Student student);

    void deleteById(Long id);

    List<Teacher> findTeachersByStudentId(Long studentId);
}