package com.demo.domain.dto.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddClazzDTO {
    private Integer gradeNo;

    private Integer clazzNo;
}
