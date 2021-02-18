package com.shenxu.zuul;

import com.shenxu.zuul.properties.ShenxuProperties;
import com.shenxu.zuul.util.HuaweiSaasUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 测试一下zuul的功能
 * @author shenxu
 */

@EnableZuulProxy
@SpringBootApplication
@EnableScheduling
@ServletComponentScan("com.shenxu.zuul.filter.servlet") // 注册过滤器
public class ZuulApplication {

    @Autowired
    ShenxuProperties shenxuProperties;

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @PostConstruct
    void init(){
        System.out.println("===================");
        System.out.println(shenxuProperties.getHost() + "=================");
    }

    /**
     * 测试华为SaaS签名实验
     */
//    @PostConstruct
//    public void test(){
//
//        String key = "dc8c2cfb-f67c-4912-96ca-a9a9ce705ff4";
//
//        String mobile = HuaweiSaasUtil.decryptMobilePhoneOrEMail(key, "417qN50K7TB7Y4merDAMxmo+h7gId8M7A+1jhw==", 256);
//        String emial = HuaweiSaasUtil.decryptMobilePhoneOrEMail(key, "9e9WV30tpF68dI52IqL7K3WVtxL+tVmskm0HSQKbgG0iywe+DNxAvCYFrTU=", 256);
//
//        String kk = URLEncoder.encode("9e9WV30tpF68dI52IqL7K3WVtxL+tVmskm0HSQKbgG0iywe+DNxAvCYFrTU=");
//        String ee = URLDecoder.decode(kk);
//
//        System.out.println("================================");
//        System.out.println(kk);
//        System.out.println(ee);
//        System.out.println("================================");
//
//    }
}
