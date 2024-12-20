package com.fpeng2288.school.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: StudentDTO
 * Package: com.fpeng2288.school.dto
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/19 23:51
 * @version 1.0
 */
@Data
public class StudentDTO {
    private Long id;
    private String name;
    private Integer age;
    private String grade;
    private List<TeacherDTO> teachers = new ArrayList<>();
}
