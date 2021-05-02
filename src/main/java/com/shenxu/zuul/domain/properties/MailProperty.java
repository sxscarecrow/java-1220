package com.shenxu.zuul.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 邮件相关配置
 *
 * @author shenxu
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "config.mail")
public class MailProperty {
    /**
     * 发送邮件主机
     */
    private String host;

    private Integer port;
    /**
     * 邮箱账号
     */
    private String username;
    /**
     * 邮箱密码
     */
    private String password;
    /**
     * 邮箱发送者名称
     */
    private String from;
}
