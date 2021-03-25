package com.hnust.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/23 20:50
 */
@RestController
@Slf4j
public class OrderZKController {

    private static final String INVOKE_URL="http://cloud-provider-payment";
//    private String INVOKE_URL="http://192.168.177.103:2181";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){

        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

    }

}
