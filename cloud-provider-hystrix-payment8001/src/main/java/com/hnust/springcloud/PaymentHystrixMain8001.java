package com.hnust.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/24 14:34
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //启用短路器，结合@HystrixCommand使用，降级处理
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class);
    }




}
