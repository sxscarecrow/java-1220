package com.shenxu.zuul.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ly
 * @date 2020/8/4 19:56
 */

@Component
@RabbitListener(queues = "demoQueue")
public class DemoQueueConsumer {

    /**
     * 消息消费
     *
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void received(String msg) {
        System.out.println("[demoQueue] received message: " + msg);
    }


}
