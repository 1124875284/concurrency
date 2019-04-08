package com.hzq.highConcurrency.example.mq.kafka;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private String id;
    private String msg;

    private Date sendTime;
}
