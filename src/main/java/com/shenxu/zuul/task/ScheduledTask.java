package com.shenxu.zuul.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ly
 * @date 2020/8/27 15:12
 * @Description 简单的定时任务
 */

//@Component
public class ScheduledTask {
    /**
     * 每五秒执行一次
     */
//    @Scheduled(cron = "0/2 * * * * ?")
    public void test() {

        System.out.println("你好呀，这个不怎么友好的世界");
    }


    /* -----------------------------------------------------------
     * =================== 定时任务和队列一起使用  ================
     *
     *
     *------------------------------------------------------------*/

}
