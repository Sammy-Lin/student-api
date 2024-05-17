package com.demo.dao;

import com.demo.domain.entity.Student;
import com.demo.domain.vo.StudentVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    void deleteByClazzIdIn(List<Long> clazzIds);

    @Query("SELECT NEW com.demo.domain.vo.StudentVO(" +
            "stu.id, " +
            "stu.name, " +
            "stu.gender, " +
            "stu.clazzId, " +
            "claz.gradeNo, " +
            "claz.clazzNo, " +
            "stu.gmtCreate, " +
            "stu.gmtModified" +
            ") FROM Student stu " +
            "LEFT JOIN Clazz claz ON claz.id = stu.clazzId"
    )
    Page<StudentVO> getStudentPageData(Pageable pageable);
}
