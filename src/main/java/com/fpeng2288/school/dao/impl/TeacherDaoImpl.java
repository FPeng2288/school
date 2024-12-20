package com.fpeng2288.school.dao.impl;

import com.fpeng2288.school.dao.TeacherDao;
import com.fpeng2288.school.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ClassName: TeacherDaoImpl
 * Package: com.fpeng2288.school.dao.impl
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:50
 * @version 1.0
 */
@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Teacher> findById(Long id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        return Optional.ofNullable(teacher);
    }
}
