package com.demo.controller;

import com.demo.domain.common.Result;
import com.demo.domain.dto.student.AddStudentDTO;
import com.demo.domain.dto.student.UpdateStudentDTO;
import com.demo.domain.entity.Student;
import com.demo.exception.BusinessException;
import com.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("listStudents")
    public Result listStudents(Integer current, Integer pageSize) throws BusinessException {
        HashMap<String, Object> result = studentService.listStudents(current, pageSize);
        return Result.success(result);

    }

    @PostMapping("addStudent")
    public Result addStudent(@RequestBody AddStudentDTO addStudentDTO) throws BusinessException {
        Student student = studentService.addStudent(addStudentDTO);
        return Result.success(student);
    }

    @PostMapping("updateStudent")
    public Result updateStudent(@RequestBody UpdateStudentDTO updateStudentDTO) throws BusinessException {
        Student student = studentService.updateStudent(updateStudentDTO);
        return Result.success(student);
    }

    @DeleteMapping("delStudents")
    public Result delStudents(@RequestParam List<Long> ids) throws BusinessException {
        studentService.delStudents(ids);
        return Result.success(null);
    }

}
