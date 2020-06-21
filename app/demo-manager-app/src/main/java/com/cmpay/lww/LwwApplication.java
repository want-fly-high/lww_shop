package com.cmpay.lww;

import com.cmpay.lemon.common.LemonFramework;
import com.cmpay.lemon.framework.LemonBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@LemonBootApplication(exclude = {RabbitAutoConfiguration.class}, value = {"com.cmpay.lww"})
public class LwwApplication {
    public static void main(String[] args) {
        LemonFramework.run(LwwApplication.class, args);
    }
}