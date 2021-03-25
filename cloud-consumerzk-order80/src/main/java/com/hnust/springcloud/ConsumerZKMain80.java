package com.hnust.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/23 20:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerZKMain80.class,args);
    }

}
