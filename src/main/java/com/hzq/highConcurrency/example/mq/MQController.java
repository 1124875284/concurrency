package com.hzq.highConcurrency.example.mq;

import com.hzq.highConcurrency.example.mq.kafka.KafkaSender;
import com.hzq.highConcurrency.example.mq.rabbmit.RabbmitMQClient;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mq")
public class MQController {
    @Resource
    private RabbmitMQClient rabbmitMQClient;
    @Resource
    private KafkaSender kafkaSender;

    @RequestMapping
    @ResponseBody
    public String send(@RequestParam("message") String message){
        rabbmitMQClient.send(message);
        kafkaSender.send(message);
        return "success";
    }
}
