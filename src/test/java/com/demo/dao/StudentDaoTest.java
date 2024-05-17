package com.demo.dao;

import com.demo.domain.entity.Student;
import com.demo.domain.vo.StudentVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDaoTest {

    @Resource
    private StudentDao studentDao;

    @Test
    void testDatabase(){
        List<Student> all = studentDao.findAll();
        Assertions.assertEquals(0, all.size());
    }

    @Test
    void getStudentPageData() {
        Page<StudentVO> studentPageData =
                studentDao.getStudentPageData(PageRequest.of(0, 10));
        List<StudentVO> content = studentPageData.getContent();
        content.forEach(System.out::println);
    }
}