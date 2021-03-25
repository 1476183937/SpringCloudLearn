package com.hnust.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/22 21:07
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //启用负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
