package com.fpeng2288.school.dao;

import com.fpeng2288.school.model.Teacher;

import java.util.Optional;

/**
 * ClassName: TeacherDao
 * Package: com.fpeng2288.school.dao
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:27
 * @version 1.0
 */
public interface TeacherDao {

    Optional<Teacher> findById(Long id);
}
