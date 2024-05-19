package com.demo.service.impl;

import com.demo.dao.StudentDao;
import com.demo.domain.dto.student.AddStudentDTO;
import com.demo.domain.dto.student.UpdateStudentDTO;
import com.demo.domain.entity.Student;
import com.demo.exception.BusinessException;
import com.demo.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
class StudentServiceImplTest {

    @Resource
    private StudentDao studentDao;

    @Resource
    private StudentService studentService;

    @Test
    void testListStudents() throws BusinessException {
        HashMap<String, Object> students = studentService.listStudents(0, 5);
        Assertions.assertFalse(students.isEmpty());
        System.out.println("page 1");
        students.entrySet().forEach(System.out::println);

        students = studentService.listStudents(1, 5);
        Assertions.assertFalse(students.isEmpty());
        System.out.println("page 2");
        students.entrySet().forEach(System.out::println);

        students = studentService.listStudents(2, 5);
        Assertions.assertFalse(students.isEmpty());
        students.entrySet().forEach(System.out::println);
    }

    @Test
    void testListStudentsWithErrorParam() {
        Assertions.assertThrows(BusinessException.class, () -> {
            studentService.listStudents(-1, 10);
        });

        Assertions.assertThrows(BusinessException.class, () -> {
            studentService.listStudents(1, -1);
        });

        Assertions.assertThrows(BusinessException.class, () -> {
            studentService.listStudents(1, null);
        });
    }

    @Test
    void testAddStudent() throws BusinessException {
        AddStudentDTO addStudentDTO = new AddStudentDTO();
        addStudentDTO.setName("Fisher");
        addStudentDTO.setGender(true);
        Student student = studentService.addStudent(addStudentDTO);
        Assertions.assertTrue(student.getId() > 0);
    }

    @Test
    void testUpdateStudent() throws BusinessException {
        UpdateStudentDTO updateStudentDTO = new UpdateStudentDTO();
        long clazzId = 45L;
        updateStudentDTO.setId(10L);
        updateStudentDTO.setClazzId(clazzId);
        updateStudentDTO.setName("Saint");
        updateStudentDTO.setGender(true);
        Student student = studentService.updateStudent(updateStudentDTO);
        Assertions.assertEquals(student.getClazzId(), clazzId);

        updateStudentDTO.setId(11L);
        updateStudentDTO.setClazzId(clazzId);
        updateStudentDTO.setName("Jim");
        updateStudentDTO.setGender(true);
        student = studentService.updateStudent(updateStudentDTO);
        Assertions.assertEquals(student.getClazzId(), clazzId);

        updateStudentDTO.setId(12L);
        updateStudentDTO.setClazzId(clazzId);
        updateStudentDTO.setName("Jiao");
        updateStudentDTO.setGender(false);
        student = studentService.updateStudent(updateStudentDTO);
        Assertions.assertEquals(student.getClazzId(), clazzId);
    }

    @Test
    void testUpdateStudentWithErrorParams() throws BusinessException {
        UpdateStudentDTO updateStudentDTO = new UpdateStudentDTO();
        updateStudentDTO.setId(3L);
        updateStudentDTO.setName("Zorro");
        updateStudentDTO.setGender(true);
        Student student = studentService.updateStudent(updateStudentDTO);
        Assertions.assertEquals("Zorro", student.getName());
    }

    @Test
    void testDelStudents() throws BusinessException {
        List<Long> ids = Arrays.asList(8L, 9L, 10L);
        studentService.delStudents(ids);

        List<Student> studentList = studentDao.findAllById(ids);
        Assertions.assertEquals(0, studentList.size());
    }

    @Test
    void testDelStudentsWithErrorParams() throws BusinessException {
        Assertions.assertThrows(BusinessException.class, () -> {
            studentService.delStudents(Collections.EMPTY_LIST);
        });

        Assertions.assertThrows(BusinessException.class, () -> {
            studentService.delStudents(null);
        });
    }
}
