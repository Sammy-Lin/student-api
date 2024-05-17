package com.demo.service;

import com.demo.domain.dto.clazz.AddClazzDTO;
import com.demo.domain.dto.clazz.UpdateClazzDTO;
import com.demo.domain.entity.Clazz;
import com.demo.exception.BusinessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ClazzService {

    HashMap<String, Object> listClazzs(Integer currentPage, Integer pageSize) throws BusinessException;

    Clazz addClazz(AddClazzDTO addClazzDTO) throws BusinessException;

    Clazz updateClazz(UpdateClazzDTO updateClazzDTO) throws BusinessException;

    void delClazzs(List<Long> ids) throws BusinessException;

    Map<Long, Object> getSelectionData();
}
