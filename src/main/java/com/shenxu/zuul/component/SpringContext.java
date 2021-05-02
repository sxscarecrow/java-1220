package com.shenxu.zuul.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;
import org.springframework.stereotype.Component;

/**
 * Spring Context 组件
 *
 * @Author shenxu
 * @Date 2021/4/11 1:00 下午
 */
@Component
public class SpringContext implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

}
