package com.fengfan.mq;

import com.fengfan.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "feng")
public class DemoQueueConsumer {

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("接收 message: " + msg);
    }
}
