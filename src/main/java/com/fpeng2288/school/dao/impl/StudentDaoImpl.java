package com.fpeng2288.school.dao.impl;

import com.fpeng2288.school.dao.StudentDao;
import com.fpeng2288.school.model.Student;
import com.fpeng2288.school.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: StudentDaoImpl
 * Package: com.fpeng2288.school.dao.impl
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:49
 * @version 1.0
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery(
                "SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.studentTeachers st LEFT JOIN FETCH st.teacher",
                Student.class
        ).getResultList();
    }

    @Override
    public List<Student> findByAgeRange(int minAge, int maxAge) {
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.studentTeachers st LEFT JOIN FETCH st.teacher " +
                        "WHERE s.age BETWEEN :minAge AND :maxAge",
                Student.class
        );
        query.setParameter("minAge", minAge);
        query.setParameter("maxAge", maxAge);
        return query.getResultList();
    }

    @Override
    public Optional<Student> findById(Long id) {
        List<Student> results = entityManager.createQuery(
                        "SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.studentTeachers st LEFT JOIN FETCH st.teacher WHERE s.id = :id",
                        Student.class
                )
                .setParameter("id", id)
                .getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public Student save(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
            return student;
        } else {
            return entityManager.merge(student);
        }
    }

    @Override
    public void deleteById(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public List<Teacher> findTeachersByStudentId(Long studentId) {
        return entityManager.createQuery(
                        "SELECT DISTINCT t FROM Teacher t " +
                                "JOIN t.studentTeachers st " +
                                "JOIN st.student s " +
                                "WHERE s.id = :studentId",
                        Teacher.class
                )
                .setParameter("studentId", studentId)
                .getResultList();
    }
}
