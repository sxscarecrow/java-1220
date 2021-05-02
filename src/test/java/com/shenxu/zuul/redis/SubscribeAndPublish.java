package com.shenxu.zuul.redis;

import com.shenxu.zuul.ZuulApplication;
import com.shenxu.zuul.util.RedisCacheComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试一下redis的与订阅
 *
 * @author shen_xu
 * @ClassName SubscribeAndPublish
 */

@SpringBootTest(classes = ZuulApplication.class)
@RunWith(SpringRunner.class)
public class SubscribeAndPublish {

    @Autowired
    private RedisCacheComponent redisCacheComponent;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 每五秒发送一次信息
     */
//    @Scheduled(cron = "0/2 * * * * ?")
    @Test
    public void publish() {
        redisCacheComponent.publish("shenxu", "hello world" + Math.random());
    }

}
