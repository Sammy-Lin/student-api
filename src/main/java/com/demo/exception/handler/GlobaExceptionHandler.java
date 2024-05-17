package com.demo.exception.handler;

import com.demo.domain.common.Result;
import com.demo.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobaExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result error(BusinessException exception){
        Result error = Result.error(null);
        error.setMessage(exception.getMessage());
        return error;
    }
}
