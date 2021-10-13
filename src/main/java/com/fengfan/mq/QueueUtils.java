package com.fengfan.mq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 26086
 */
@Component
@Data
@ConfigurationProperties(prefix = "mq")
public class QueueUtils {
    public String queueName;
}

