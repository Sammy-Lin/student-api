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

/**
 * Class API
 */
@RestController
@RequestMapping("clazz")
public class ClazzController {

    @Resource
    private ClazzService clazzService;

    /**
     * class list API
     * @param current   current page number
     * @param pageSize  size per page
     * @return
     * @throws BusinessException
     */
    @GetMapping("listClazzs")
    public Result listClazzs(Integer current, Integer pageSize) throws BusinessException {
        HashMap<String, Object> clazzs = clazzService.listClazzs(current, pageSize);
        return Result.success(clazzs);
    }

    /**
     * add class API
     * @param addClazzDTO   add Class entity
     * @return
     * @throws BusinessException
     */
    @PostMapping("addClazz")
    public Result addClazz(@RequestBody AddClazzDTO addClazzDTO) throws BusinessException {
        Clazz clazz = clazzService.addClazz(addClazzDTO);
        return Result.success(clazz);
    }

    /**
     * update class API
     * @param updateClazzDTO    update Class entity
     * @return
     * @throws BusinessException
     */
    @PostMapping("updateClazz")
    public Result updateClazz(@RequestBody UpdateClazzDTO updateClazzDTO) throws BusinessException {
        Clazz clazz = clazzService.updateClazz(updateClazzDTO);
        return Result.success(clazz);
    }

    /**
     * delete class API
     * @param ids   class ids
     * @return
     * @throws BusinessException
     */
    @DeleteMapping("delClazzs")
    public Result delClazzs(@RequestParam List<Long> ids) throws BusinessException {
        clazzService.delClazzs(ids);
        return Result.success(null);
    }

    /**
     * class selection data API
     * @return
     */
    @PostMapping("selection")
    public Result selection() {
        Map<Long, Object> clazzSelectionData = clazzService.getSelectionData();
        return Result.success(clazzSelectionData);
    }
}
