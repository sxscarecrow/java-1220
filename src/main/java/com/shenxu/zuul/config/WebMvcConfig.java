package com.shenxu.zuul.config;

import com.shenxu.zuul.util.RedisCacheComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ly
 * @date 2020/8/3 18:55
 */

@Configuration
public class WebMvcConfig {

    /**
     * zuul处理跨域问题
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/first/**")
                        .allowedOrigins("http://127.0.0.1:8005") // 应该是发送请求的地址 然后转发到 “/first/**”
                        .allowedMethods("GET", "POST");
            }
        };
    }

    /**
     * redis 的封装处理
     * @return
     */
//    @Bean
//    public RedisCacheComponent redisCacheComponent(){
//        return new RedisCacheComponent();
//    }


}
