package com.shenxu.zuul.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 广播模式消费
 *
 * @author ly
 * @date 2020/8/4 20:13
 */

@Component
public class FanoutConsumer {

    @RabbitListener(queues = "fanout.a")
    @RabbitHandler
    public void receivedA(String msg) {
        System.out.println("[fanout.a] receivedA message: " + msg);
    }


    @RabbitListener(queues = "fanout.b")
    @RabbitHandler
    public void receivedB(String msg) {
        System.out.println("[fanout.b] receivedB message: " + msg);
    }


    @RabbitListener(queues = "fanout.b")
    @RabbitHandler
    public void receivedC(String msg) {
        if (msg == null) {
            System.out.println("该队列没有了消息可供消费");
        }
        System.out.println("[fanout.c] receivedC message: " + msg);
    }
}
