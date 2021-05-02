package com.shenxu.zuul.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shen_xu
 * @date 2021/4/11 2:08 下午
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "shenxu-user")
public class ShenxuProperty {
    private String host;
    private String port;
}
