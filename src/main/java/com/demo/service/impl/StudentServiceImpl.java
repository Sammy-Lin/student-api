package com.demo.service.impl;

import com.demo.dao.StudentDao;
import com.demo.domain.dto.student.AddStudentDTO;
import com.demo.domain.dto.student.UpdateStudentDTO;
import com.demo.domain.entity.Student;
import com.demo.domain.vo.StudentVO;
import com.demo.exception.BusinessException;
import com.demo.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public HashMap<String, Object> listStudents(Integer currentPage, Integer pageSize) throws BusinessException {
        if (currentPage == null || currentPage < 0 || pageSize == null || pageSize < 1) {
            throw new BusinessException("参数错误");
        }
        Page<StudentVO> studentPage = studentDao.getStudentPageData(PageRequest.of(currentPage - 1, pageSize));
        HashMap<String, Object> pageResult = new HashMap<>();
        pageResult.put("total", studentPage.getTotalElements());
        pageResult.put("list", studentPage.getContent());
        return pageResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student addStudent(AddStudentDTO addStudentDTO) throws BusinessException {
        boolean valid = ObjectUtils.isEmpty(addStudentDTO) ||
                !StringUtils.hasText(addStudentDTO.getName()) ||
                ObjectUtils.isEmpty(addStudentDTO.getGender());
        if (valid) {
            throw new BusinessException("参数为空");
        }
        Student savedStudent = new Student();
        BeanUtils.copyProperties(addStudentDTO, savedStudent);
        savedStudent = studentDao.save(savedStudent);
        return savedStudent;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student updateStudent(UpdateStudentDTO updateStudentDTO) throws BusinessException {
        boolean valid = ObjectUtils.isEmpty(updateStudentDTO) ||
                !StringUtils.hasText(updateStudentDTO.getName()) ||
                ObjectUtils.isEmpty(updateStudentDTO.getGender());
        if (valid) {
            throw new BusinessException("参数为空");
        }
        Optional<Student> oldStudent = studentDao.findById(updateStudentDTO.getId());
        if (oldStudent.isEmpty()) {
            throw new BusinessException("数据已修改");
        }
        Student updateStudent = new Student();
        BeanUtils.copyProperties(oldStudent.get(), updateStudent);
        BeanUtils.copyProperties(updateStudentDTO, updateStudent);
        updateStudent = studentDao.save(updateStudent);
        return updateStudent;
    }

    @Override
    public void delStudents(List<Long> ids) throws BusinessException {
        if (CollectionUtils.isEmpty(ids)) {
            throw new BusinessException("参数为空");
        }
        studentDao.deleteAllByIdInBatch(ids);
        return;
    }
}
