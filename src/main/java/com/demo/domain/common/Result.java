package com.demo.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        return new Result(2000, "SUCCESS", data);
    }


    public static Result error(Object data) {
        return new Result(5000, "ERROR", data);
    }
}
