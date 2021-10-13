package com.fengfan.config;

import com.fengfan.mq.QueueUtils;
import lombok.Data;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Autowired
    QueueUtils util;
    /**
     * 定义demoQueue队列
     * @return
     */
    @Bean
    public Queue demoString() {
        System.out.println("------------"+ util.queueName);
        return new Queue("feng");
    }
}
