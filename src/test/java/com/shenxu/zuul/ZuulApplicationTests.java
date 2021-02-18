package com.shenxu.zuul;

import com.shenxu.zuul.config.RedisConfig;
import com.shenxu.zuul.properties.ShenxuProperties;
import com.shenxu.zuul.util.HuaweiSaasUtil;
import com.shenxu.zuul.util.RedisCacheComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class ZuulApplicationTests {

    @Autowired
    private ShenxuProperties shenxuProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisCacheComponent redisCacheComponent;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        String key = "dc8c2cfb-f67c-4912-96ca-a9a9ce705ff4";
        String mobile = HuaweiSaasUtil.decryptMobilePhoneOrEMail(key, "30xXRvwZ4cf69365hNwQMrzxAH4SQ8nNbl3U1g==", 40);
        System.out.println(mobile);
    }

    /**
     * 测试获取配置项
     */
    @Test
    void properties(){
        System.out.println(shenxuProperties.getHost() + " : " + shenxuProperties.getPort());
        System.out.println(shenxuProperties.getClass());
    }

    @Test
    void redis(){
        redisTemplate.opsForValue().set("SHENXU", "SHENXU");
        redisCacheComponent.set("sss", "SHENXU");
    }

    public static void main(String[] args) {
        Set<String> test = new HashSet<>();

        test.add("hello");
        test.add("hello");
        test.add("world");

        System.out.println(test);
        // 竟然没有报错 只是添加不进去而已
    }

}
