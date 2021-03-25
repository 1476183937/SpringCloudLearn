package com.hnust.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/21 12:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code; //返回结果：如404
    private String message;//返回结果的信息
    private T      date;   //返回结果中的数据

    public CommonResult(Integer code,String message){
        this(code, message,null);
    }

}
