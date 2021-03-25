package com.hnust.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/24 14:25
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLeavel(){
        return Logger.Level.FULL;
    }

}
