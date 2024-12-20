package com.fpeng2288.school.service.impl;

import com.fpeng2288.school.dao.StudentDao;
import com.fpeng2288.school.dto.StudentDTO;
import com.fpeng2288.school.dto.TeacherDTO;
import com.fpeng2288.school.model.Student;
import com.fpeng2288.school.model.Teacher;
import com.fpeng2288.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ClassName: StudentServiceImpl
 * Package: com.fpeng2288.school.service
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:32
 * @version 1.0
 */
@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findAllStudents() {
        return studentDao.findAll().stream()
                .map(this::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findStudentsByAgeRange(int minAge, int maxAge) {
        if (minAge > maxAge) {
            throw new IllegalArgumentException("Min age cannot be greater than max age");
        }
        return studentDao.findByAgeRange(minAge, maxAge).stream()
                .map(this::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StudentDTO> findStudentById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }
        return studentDao.findById(id)
                .map(this::toStudentDTO);
    }

    @Override
    public StudentDTO saveStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        return toStudentDTO(studentDao.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }
        studentDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeacherDTO> findTeachersByStudentId(Long studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }
        return studentDao.findTeachersByStudentId(studentId).stream()
                .map(this::toTeacherDTO)
                .collect(Collectors.toList());
    }

    private StudentDTO toStudentDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setGrade(student.getGrade());

        List<TeacherDTO> teacherDTOs = student.getStudentTeachers().stream()
                .map(st -> toTeacherDTO(st.getTeacher()))
                .collect(Collectors.toList());
        dto.setTeachers(teacherDTOs);

        return dto;
    }

    private TeacherDTO toTeacherDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setSubject(teacher.getSubject());
        return dto;
    }
}