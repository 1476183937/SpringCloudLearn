package com.hnust.springcloud.service;

import com.hnust.springcloud.entities.CommonResult;
import com.hnust.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/27 21:28
 */

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回，----PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}