package com.hnust.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: 使用zookeeper作为注册中心
 * @Author: ggh
 * @Date: 2020/4/23 20:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8004.class);
    }

}
