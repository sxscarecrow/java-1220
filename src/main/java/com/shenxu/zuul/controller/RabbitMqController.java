package com.shenxu.zuul.controller;

import com.shenxu.zuul.consumer.FanoutConsumer;
import com.shenxu.zuul.producor.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 * @date 2020/8/4 19:59
 */

@RestController
public class RabbitMqController {

    @Autowired
    private RabbitProducer rabbitProducer;

    @Autowired
    private FanoutConsumer fanoutConsumer;

    /**
     * 默认模式
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/sendDemoQueue")
    public Object sendDemoQueue() throws InterruptedException {
        rabbitProducer.sendDemoQueue();
        return "success";
    }

    /**
     * 广播模式
     *
     * @return
     */
    @GetMapping("/sendFanout")
    public Object sendFanout() {
        rabbitProducer.sendFanout();
        return "success";
    }
}
