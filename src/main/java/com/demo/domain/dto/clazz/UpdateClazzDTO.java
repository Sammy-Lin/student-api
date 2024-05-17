package com.demo.domain.dto.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClazzDTO {
    private Long id;

    private Integer gradeNo;

    private Integer clazzNo;
}
