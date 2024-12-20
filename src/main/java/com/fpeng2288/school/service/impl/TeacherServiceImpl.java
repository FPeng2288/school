package com.fpeng2288.school.service.impl;

import com.fpeng2288.school.dao.TeacherDao;
import com.fpeng2288.school.dto.TeacherDTO;
import com.fpeng2288.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ClassName: TeacherServiceImpl
 * Package: com.fpeng2288.school.service.impl
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:33
 * @version 1.0
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    @Override
    @Transactional(readOnly = true)
    public Optional<TeacherDTO> findTeacherById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Teacher ID cannot be null");
        }
        return teacherDao.findById(id)
                .map(teacher -> {
                    TeacherDTO dto = new TeacherDTO();
                    dto.setId(teacher.getId());
                    dto.setName(teacher.getName());
                    dto.setSubject(teacher.getSubject());
                    return dto;
                });
    }
}