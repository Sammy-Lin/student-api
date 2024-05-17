package com.demo.domain.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentDTO {

    private Long id;

    private String name;

    private Boolean gender;

    private Long clazzId;
}
