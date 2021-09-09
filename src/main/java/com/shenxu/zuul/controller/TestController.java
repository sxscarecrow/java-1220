package com.shenxu.zuul.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author shenxu
 * @date 2020.08.03 18:17
 */
@Log4j2
@RestController
@RequestMapping("/shenxu")
public class TestController {

    @GetMapping("/test")
    public Integer test() {
        return 2047;
    }


    @PostMapping("demoSaas")
    public Map<Integer, String> demo(HttpServletRequest request) {
        Map<String, String[]> paramsMap = request.getParameterMap();

        int a = 4;
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "33");

        return stringMap;
    }

    /**
     * 测试异步执行 但是有返回值
     *
     * @return
     * @throws InterruptedException
     */
    @Async
    @GetMapping("/async/return")
    public Future<String> asyncReturn() throws InterruptedException {
        System.out.println("------有返回值===>开始执行");
        Thread.sleep(10000);
        System.out.println("-------执行完成");
        return new AsyncResult<>("hello world");
    }

    @Async
    @GetMapping("/async")
    public void async() throws InterruptedException {
        System.out.println("------没有返回值的====>开始执行");
        Thread.sleep(10000);
        System.out.println("--------没有返回值的=====>执行完成");
    }


}
