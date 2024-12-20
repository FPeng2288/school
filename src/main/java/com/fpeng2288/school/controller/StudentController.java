package com.fpeng2288.school.controller;

import com.fpeng2288.school.dto.StudentDTO;
import com.fpeng2288.school.dto.TeacherDTO;
import com.fpeng2288.school.model.Student;
import com.fpeng2288.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: StudentController
 * Package: com.fpeng2288.school.controller
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:34
 * @version 1.0
 */
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge) {
        if (minAge != null && maxAge != null) {
            return ResponseEntity.ok(studentService.findStudentsByAgeRange(minAge, maxAge));
        }
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity<List<TeacherDTO>> getTeachersByStudentId(@PathVariable Long id) {
        List<TeacherDTO> teachers = studentService.findTeachersByStudentId(id);
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {
        student.setId(id);
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}