package com.shenxu.zuul.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shenxu
 * @date 2020.08.03 18:17
 */
@Log4j2
@RestController
@RequestMapping("/shenxu")
public class TestController {

    @GetMapping("/test")
    public Integer test(){
        return 2047;
    }


    @PostMapping("demoSaas")
    public Map<Integer, String> demo(HttpServletRequest request){

        Map<String, String[]> paramsMap = request.getParameterMap();

        int a = 4;
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "33");

        return stringMap;
    }


}
