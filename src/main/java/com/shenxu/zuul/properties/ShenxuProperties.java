package com.shenxu.zuul.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ly
 * @date 2020/8/12 11:59
 * @Description  获取配置项的一种方式
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "shenxu-user")
public class ShenxuProperties {
    private String host;
    private String port;
}
