package com.shenxu.zuul.producor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ly
 * @date 2020/8/4 19:54
 */

@Component
public class RabbitProducer {

    private final static int NUM = 20;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendDemoQueue() throws InterruptedException {
        for (int i = 0; i < NUM; i++) {
            Date date = new Date();
            String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
            System.out.println("[demoQueue] send msg: " + dateString);
            // 第一个参数为刚刚定义的队列名称
            rabbitTemplate.convertAndSend("demoQueue", dateString);
            Thread.sleep(2000);
        }

        System.out.println("============消息发送完成=============");
    }

    /**
     * 广播模式
     */
    public void sendFanout() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        System.out.println("[fanout] send msg:" + dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey 我们不用管空着就可以，第三个是你要发送的消息
        rabbitTemplate.convertAndSend("fanoutExchange", "", dateString);
    }

}
