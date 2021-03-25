package com.hnust.springcloud.service;

import com.hnust.springcloud.entities.CommonResult;
import com.hnust.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/27 21:28
 */
//使用OpenFeign降级调用必须在yml文件配置激活sentinel对feign的支持
    //当被调用的服务出故障宕机时，消费者就会转而调用该方法进行处理
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
