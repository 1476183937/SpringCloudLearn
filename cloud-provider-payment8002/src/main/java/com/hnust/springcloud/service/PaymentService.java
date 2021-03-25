package com.hnust.springcloud.service;

import com.hnust.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/21 12:23
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
