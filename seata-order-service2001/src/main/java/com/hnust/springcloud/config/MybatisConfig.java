package com.hnust.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/28 20:40
 */
@Configuration
@MapperScan({"com.hnust.springcloud.dao"})
public class MybatisConfig {
}
