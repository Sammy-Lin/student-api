package com.demo.service.impl;

import com.demo.dao.ClazzDao;
import com.demo.dao.StudentDao;
import com.demo.domain.dto.clazz.AddClazzDTO;
import com.demo.domain.dto.clazz.UpdateClazzDTO;
import com.demo.domain.entity.Clazz;
import com.demo.domain.vo.ClazzSelectionVO;
import com.demo.exception.BusinessException;
import com.demo.service.ClazzService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.*;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Resource
    private ClazzDao clazzDao;

    @Resource
    private StudentDao studentDao;

    @Override
    public HashMap<String, Object> listClazzs(Integer current, Integer pageSize) throws BusinessException {
        boolean invalid = current == null || pageSize == null || current < 0 || pageSize < 1;
        if (invalid) {
            throw new BusinessException("参数错误");
        }
        Page<Clazz> page = clazzDao.findAll(PageRequest.of(current - 1, pageSize));
        HashMap<String, Object> pageResult = new HashMap<>();
        pageResult.put("total", page.getTotalElements());
        pageResult.put("list", page.getContent());
        return pageResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Clazz addClazz(AddClazzDTO addClazzDTO) throws BusinessException {
        boolean invalid = ObjectUtils.isEmpty(addClazzDTO)
                || ObjectUtils.isEmpty(addClazzDTO.getGradeNo())
                || ObjectUtils.isEmpty(addClazzDTO.getClazzNo())
                || addClazzDTO.getGradeNo() < 1
                || addClazzDTO.getClazzNo() < 1;
        if (invalid) {
            throw new BusinessException("参数错误");
        }
        // check data if exists
        Clazz old = clazzDao.findClazzByGradeNoAndClazzNo(addClazzDTO.getGradeNo(), addClazzDTO.getClazzNo());
        if (old != null) {
            throw new BusinessException("数据已存在");
        }
        Clazz clazz = new Clazz();
        BeanUtils.copyProperties(addClazzDTO, clazz);
        clazz = clazzDao.save(clazz);
        return clazz;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Clazz updateClazz(UpdateClazzDTO updateClazzDTO) throws BusinessException {
        boolean invalid = ObjectUtils.isEmpty(updateClazzDTO)
                || ObjectUtils.isEmpty(updateClazzDTO.getGradeNo())
                || ObjectUtils.isEmpty(updateClazzDTO.getClazzNo())
                || updateClazzDTO.getGradeNo() < 1
                || updateClazzDTO.getClazzNo() < 1;
        if (invalid) {
            throw new BusinessException("参数错误");
        }
        // check data if exists
        Clazz old = clazzDao.findClazzByGradeNoAndClazzNo(updateClazzDTO.getGradeNo(), updateClazzDTO.getClazzNo());
        if (old != null && !old.getId().equals(updateClazzDTO.getId())) {
            throw new BusinessException("数据已存在");
        }
        Clazz clazz = new Clazz();
        if (ObjectUtils.isEmpty(old)) {
            Optional<Clazz> oldClazz = clazzDao.findById(updateClazzDTO.getId());
            if (oldClazz.isEmpty()) {
                throw new BusinessException("数据已修改");
            }
            old = oldClazz.get();
        }
        BeanUtils.copyProperties(old, clazz);
        BeanUtils.copyProperties(updateClazzDTO, clazz);
        clazz = clazzDao.save(clazz);
        return clazz;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delClazzs(List<Long> ids) throws BusinessException {
        if (CollectionUtils.isEmpty(ids)) {
            throw new BusinessException("参数错误");
        }
        // delete clazz first then delete students related to these clazz
        clazzDao.deleteAllByIdInBatch(ids);
        studentDao.deleteByClazzIdIn(ids);
    }

    @Override
    public Map<Long, Object> getSelectionData() {
        List<ClazzSelectionVO> clazzList = clazzDao.findClazzSelctionData();
        HashMap<Long, Object> resultMap = new HashMap<>();
        StringBuilder buf = new StringBuilder();
        for (ClazzSelectionVO clazz : clazzList) {
            buf.setLength(0);
            Integer gradeNo = clazz.getGradeNo();
            Integer clazzNo = clazz.getClazzNo();
            String label = buf.append(gradeNo).append("年")
                            .append(clazzNo).append("班").toString();
            resultMap.put(clazz.getId(), label);
        }
        return resultMap;
    }
}
