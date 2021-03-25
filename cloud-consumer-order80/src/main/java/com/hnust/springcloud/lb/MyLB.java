package com.hnust.springcloud.lb;

import com.netflix.ribbon.proxy.annotation.Var;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title:自定义负载均衡器
 * @Author: ggh
 * @Date: 2020/4/24 13:18
 */
@Component
public class MyLB implements LoadBalancer{

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){

        int current, next;
        do{
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0:current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));

        System.out.println("第几次访问，次数next：" + next);
        return next;


    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
