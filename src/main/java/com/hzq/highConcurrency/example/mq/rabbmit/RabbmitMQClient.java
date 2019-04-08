package com.hzq.highConcurrency.example.mq.rabbmit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class RabbmitMQClient {
    @Resource
    private RabbitTemplate rabbmitTemplate;

    public void send(String mesage){
        rabbmitTemplate.convertAndSend(QueueConstants.TEST,mesage);
    }
}
