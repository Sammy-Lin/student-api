package com.demo.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StudentVO {

    public StudentVO(Long id, String name, Boolean gender, Long clazzId, Integer gradeNo, Integer clazzNo, LocalDateTime gmtCreate, LocalDateTime gmtModified) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.clazzId = clazzId;
        this.gradeNo = gradeNo;
        this.clazzNo = clazzNo;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    private Long id;

    private String name;

    private Boolean gender;

    private Long clazzId;

    private Integer gradeNo;

    private Integer clazzNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
}
