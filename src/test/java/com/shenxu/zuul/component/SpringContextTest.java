//package com.shenxu.zuul.component;
//
//import com.shenxu.zuul.ZuulApplication;
//import com.shenxu.zuul.domain.properties.MailProperty;
//import com.shenxu.zuul.domain.properties.ShenxuProperty;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author shen_xu
// * @date 2021/4/11 1:00 下午
// */
//
//@SpringBootTest(classes = ZuulApplication.class)
//@RunWith(SpringRunner.class)
//public class SpringContextTest {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    private static ShenxuProperty shenxuProperty = SpringContext.getBean("shenxuProperty", ShenxuProperty.class);
//
//    @Test
//    public void test() {
//        // 根据自身去获取
//        System.out.println("-----" + applicationContext.hashCode());
//
//        // 自定义实现去获取
//        System.out.println("-----" + SpringContext.applicationContext.hashCode());
//
//        System.out.println("默认->" + applicationContext.getBean(MailProperty.class).hashCode());
//        System.out.println("自定义mailProperty->" + shenxuProperty.hashCode());
//    }
//}
