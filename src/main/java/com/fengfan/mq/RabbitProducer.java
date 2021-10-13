package com.fengfan.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class RabbitProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendDemoQueue(String MSG) {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date)+MSG;
        System.out.println("发送 msg: " + dateString);
        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend("feng", dateString);
    }
}
