package com.demo.service;

import com.demo.domain.dto.student.AddStudentDTO;
import com.demo.domain.dto.student.UpdateStudentDTO;
import com.demo.domain.entity.Student;
import com.demo.exception.BusinessException;

import java.util.HashMap;
import java.util.List;

public interface StudentService {

    HashMap<String, Object> listStudents(Integer currentPage, Integer pageSize) throws BusinessException;

    Student addStudent(AddStudentDTO addStudentDTO) throws BusinessException;

    Student updateStudent(UpdateStudentDTO updateStudentDTO) throws BusinessException;

    void delStudents(List<Long> ids) throws BusinessException;
}
