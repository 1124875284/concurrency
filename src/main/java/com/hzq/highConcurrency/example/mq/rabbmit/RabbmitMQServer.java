package com.hzq.highConcurrency.example.mq.rabbmit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbmitMQServer {
    @RabbitListener(queues = QueueConstants.TEST)
    private void receive(String message){
        log.info("receive :{}",message);
    }
}
