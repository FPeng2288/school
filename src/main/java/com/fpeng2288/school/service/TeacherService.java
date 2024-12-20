package com.fpeng2288.school.service;

import com.fpeng2288.school.dto.TeacherDTO;

import java.util.Optional;

/**
 * ClassName: TeacherService
 * Package: com.fpeng2288.school.service
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:31
 * @version 1.0
 */
public interface TeacherService {

    Optional<TeacherDTO> findTeacherById(Long id);
}
