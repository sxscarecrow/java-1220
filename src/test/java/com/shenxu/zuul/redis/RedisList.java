package com.shenxu.zuul.redis;

import com.shenxu.zuul.ZuulApplication;
import com.shenxu.zuul.util.RedisCacheComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ly
 * @date 2020/8/21 18:34
 */

@SpringBootTest(classes = ZuulApplication.class)
@RunWith(SpringRunner.class)
public class RedisList {

    @Autowired
    private RedisCacheComponent redisCacheComponent;

    @Test
    public void redisList(){
        redisCacheComponent.set("key4", "value4");
        System.out.println(redisCacheComponent.get("qwer"));
    }
}
