package com.hnust.springcloud;

import com.hnust.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

import javax.naming.Name;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/22 21:04
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
//使用自定义的负载均衡：随机负载均衡
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }

}
