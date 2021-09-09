package com.shenxu.zuul.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shen_xu
 * @date 2021/6/25 9:06 下午
 */
@Configuration
public class ExecutorService {
    @Bean
    public java.util.concurrent.ExecutorService executorService(){
        ThreadFactory build = new ThreadFactoryBuilder().build();
        return new ThreadPoolExecutor(10, 21, 10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(20000), build);
    }
}
