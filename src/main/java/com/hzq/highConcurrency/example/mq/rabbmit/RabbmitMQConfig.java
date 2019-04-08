package com.hzq.highConcurrency.example.mq.rabbmit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class RabbmitMQConfig {

    @Bean
    public Queue queue(){
        return new Queue(QueueConstants.TEST);
    }
}
