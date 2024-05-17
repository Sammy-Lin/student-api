package com.demo.dao;

import com.demo.domain.entity.Clazz;
import com.demo.domain.entity.Student;
import com.demo.domain.vo.ClazzSelectionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClazzDao extends JpaRepository<Clazz, Long> {
    Clazz findClazzByGradeNoAndClazzNo(Integer gradeNo, Integer clazzNo);

    @Query("SELECT NEW com.demo.domain.vo.ClazzSelectionVO(c.id, c.gradeNo, c.clazzNo)" +
            " FROM Clazz c ORDER BY c.gradeNo ASC, c.clazzNo ASC")
    List<ClazzSelectionVO> findClazzSelctionData();


}
