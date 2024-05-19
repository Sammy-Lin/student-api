package com.demo.service.impl;

import com.demo.dao.ClazzDao;
import com.demo.domain.dto.clazz.AddClazzDTO;
import com.demo.domain.dto.clazz.UpdateClazzDTO;
import com.demo.domain.entity.Clazz;
import com.demo.exception.BusinessException;
import com.demo.service.ClazzService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClazzServiceImplTest {

    @Resource
    @Mock
    private ClazzService clazzService;

    @Autowired
    private ClazzDao clazzDao;

    @Test
    void listClazzs() throws BusinessException {
        HashMap<String, Object> result = clazzService.listClazzs(1, 10);
        List<Clazz> list = (List<Clazz>) result.get("list");
        assertFalse(list.isEmpty());
    }

    @Test
    void listClazzsWithErrorParams() throws BusinessException {
        assertThrows(BusinessException.class, () -> {
            clazzService.listClazzs(null, 10);
        });

        assertThrows(BusinessException.class, () -> {
            clazzService.listClazzs(2, null);
        });

        assertThrows(BusinessException.class, () -> {
            clazzService.listClazzs(1, 0);
        });


        assertThrows(BusinessException.class, () -> {
            clazzService.listClazzs(1, -10);
        });
    }

    @Test
    void addClazz() throws BusinessException {
        AddClazzDTO addClazzDTO = new AddClazzDTO();
        int gradeNo = 1;
        int clazzNo = 1;
        addClazzDTO.setGradeNo(gradeNo);
        addClazzDTO.setClazzNo(clazzNo);
        Clazz clazz = clazzService.addClazz(addClazzDTO);
        Assertions.assertEquals(clazz.getGradeNo(), gradeNo);
        Assertions.assertEquals(clazz.getClazzNo(), clazzNo);
    }

    @Test
    void addClazzWithExistData() throws BusinessException {
        AddClazzDTO addClazzDTO = new AddClazzDTO();
        Integer gradeNo = 1;
        Integer clazzNo = 1;
        addClazzDTO.setGradeNo(gradeNo);
        addClazzDTO.setClazzNo(clazzNo);
        Assertions.assertThrows(BusinessException.class, () -> {
            clazzService.addClazz(addClazzDTO);
        });
    }

    @Test
    void addClazzWithErrorParams() throws BusinessException {
        Assertions.assertThrows(BusinessException.class, () -> {
            clazzService.addClazz(null);
        });

        AddClazzDTO addClazzDTO = new AddClazzDTO();
        Integer gradeNo = null;
        Integer clazzNo = 1;
        addClazzDTO.setGradeNo(gradeNo);
        addClazzDTO.setClazzNo(clazzNo);
        Assertions.assertThrows(BusinessException.class, () -> {
            clazzService.addClazz(addClazzDTO);
        });

        gradeNo = 1;
        clazzNo = -1;
        addClazzDTO.setGradeNo(gradeNo);
        addClazzDTO.setClazzNo(clazzNo);
        Assertions.assertThrows(BusinessException.class, () -> {
            clazzService.addClazz(addClazzDTO);
        });

        gradeNo = 1;
        clazzNo = 0;
        addClazzDTO.setGradeNo(gradeNo);
        addClazzDTO.setClazzNo(clazzNo);
        Assertions.assertThrows(BusinessException.class, () -> {
            clazzService.addClazz(addClazzDTO);
        });
    }

    @Test
    void addClazzData() throws BusinessException {
        AddClazzDTO addClazzDTO;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 5; j++) {
                addClazzDTO = new AddClazzDTO();
                addClazzDTO.setGradeNo(i);
                addClazzDTO.setClazzNo(j);
                clazzService.addClazz(addClazzDTO);
            }
        }
    }

    @Test
    void updateClazz() throws BusinessException {
        UpdateClazzDTO updateClazzDTO = new UpdateClazzDTO();
        updateClazzDTO.setId(1L);
        int gradeNo = 1;
        int clazzNo = 1;
        updateClazzDTO.setGradeNo(gradeNo);
        updateClazzDTO.setClazzNo(clazzNo);
        Clazz clazz = clazzService.updateClazz(updateClazzDTO);
        assertEquals(clazz.getGradeNo(), gradeNo);
    }

    @Test
    void updateClazzWithErrorParams() {
        UpdateClazzDTO updateClazzDTO = new UpdateClazzDTO();
        updateClazzDTO.setId(1L);
        int gradeNo = -1;
        int clazzNo = 1;
        updateClazzDTO.setGradeNo(gradeNo);
        updateClazzDTO.setClazzNo(clazzNo);
        try {
            clazzService.updateClazz(updateClazzDTO);
        } catch (BusinessException e) {
            assertEquals(e.getMessage(), "参数错误");
        }

        try {
            clazzService.updateClazz(null);
        } catch (BusinessException e) {
            assertEquals(e.getMessage(), "参数错误");
        }
    }

    @Test
    void updateClazzWithExistData() {
        UpdateClazzDTO updateClazzDTO = new UpdateClazzDTO();
        updateClazzDTO.setId(2L);
        int gradeNo = 1;
        int clazzNo = 1;
        updateClazzDTO.setGradeNo(gradeNo);
        updateClazzDTO.setClazzNo(clazzNo);
        try {
            clazzService.updateClazz(updateClazzDTO);
        } catch (BusinessException e) {
            assertEquals(e.getMessage(), "数据已存在");
        }
    }

    @Test
    void delClazzs() throws BusinessException {
        long clazzId = 45L;
        clazzService.delClazzs(Arrays.asList(clazzId));

        Optional<Clazz> byId = clazzDao.findById(clazzId);
        assertNull(byId.orElse(null));
    }

    @Test
    void delClazzsErrorParams() {
        long clazzId = -1L;
        try {
            clazzService.delClazzs(null);
        } catch (BusinessException e) {
            assertEquals(e.getMessage(), "参数错误");
        }

        try {
            clazzService.delClazzs(Collections.EMPTY_LIST);
        } catch (BusinessException e) {
            assertEquals(e.getMessage(), "参数错误");
        }
    }

    @Test
    void getSelectionData() {
        Map<Long, Object> selectionData = clazzService.getSelectionData();
        assertFalse(selectionData.isEmpty());
        selectionData.entrySet().forEach(System.out::println);
    }
}
