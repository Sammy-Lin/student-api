package com.demo.controller;

import com.demo.domain.common.Result;
import com.demo.domain.dto.clazz.AddClazzDTO;
import com.demo.domain.dto.clazz.UpdateClazzDTO;
import com.demo.domain.entity.Clazz;
import com.demo.exception.BusinessException;
import com.demo.service.ClazzService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("clazz")
public class ClazzController {

    @Resource
    private ClazzService clazzService;

    @GetMapping("listClazzs")
    public Result listClazzs(Integer current, Integer pageSize) throws BusinessException {
        HashMap<String, Object> clazzs = clazzService.listClazzs(current, pageSize);
        return Result.success(clazzs);
    }

    @PostMapping("addClazz")
    public Result addClazz(@RequestBody AddClazzDTO addClazzDTO) throws BusinessException {
        Clazz clazz = clazzService.addClazz(addClazzDTO);
        return Result.success(clazz);
    }

    @PostMapping("updateClazz")
    public Result updateClazz(@RequestBody UpdateClazzDTO updateClazzDTO) throws BusinessException {
        Clazz clazz = clazzService.updateClazz(updateClazzDTO);
        return Result.success(clazz);
    }

    @DeleteMapping("delClazzs")
    public Result delClazzs(@RequestParam List<Long> ids) throws BusinessException {
        clazzService.delClazzs(ids);
        return Result.success(null);
    }

    @PostMapping("selection")
    public Result selection() {
        Map<Long, Object> clazzSelectionData = clazzService.getSelectionData();
        return Result.success(clazzSelectionData);
    }
}
