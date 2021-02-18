package com.shenxu.zuul.config;

import com.shenxu.zuul.filter.servlet.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 *
 * 说明： 如果使用了 @WebFilter(urlPatterns = "/*", filterName = "testFilter")
 *        和 @ServletComponentScan("com.shenxu.zuul.filter.servlet") 则不需要这个 配置类
 *
 * @author shen_xu
 * @ClassName FilterConfig
 */

@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean registFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new TestFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("TestFilter");
//        registration.setOrder(1);
//        return registration;
//    }
}
