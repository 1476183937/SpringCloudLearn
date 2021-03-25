package com.hnust.springcloud.controller;

import com.hnust.springcloud.entities.CommonResult;
import com.hnust.springcloud.entities.Payment;
import com.hnust.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/24 14:11
 */
@RestController
@Slf4j
public class FeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return paymentFeignService.getPaymentById(id);

    }

    /**
    *@title:
    *@description: 模拟feign的超时控制
    *@author:ggh
    *@updateTime: 2020/4/24 14:17
    **/
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

}
