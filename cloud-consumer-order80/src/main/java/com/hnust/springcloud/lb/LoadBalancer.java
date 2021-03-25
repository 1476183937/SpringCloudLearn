package com.hnust.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/24 13:17
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
