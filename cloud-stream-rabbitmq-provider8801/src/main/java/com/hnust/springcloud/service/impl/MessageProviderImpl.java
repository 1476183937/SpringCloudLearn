package com.hnust.springcloud.service.impl;

import com.hnust.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/4/26 12:22
 */
@EnableBinding(Source.class) //定义消息的推送管道，表示为发送端
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  //消息的发送管道

    @Override
    public String send() {

        String uuid = UUID.randomUUID().toString();
        //发送消息
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("发送消息： " + uuid);

        return null;
    }
}
