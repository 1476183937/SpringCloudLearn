package com.hnust.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import javax.swing.*;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/25 14:32
 */
@SpringBootApplication
@EnableConfigServer  //作为配置中心需要用到的注解
@EnableDiscoveryClient
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class);
    }

}
