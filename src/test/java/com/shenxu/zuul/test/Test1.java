package com.shenxu.zuul.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shen_xu
 * @date 2021/5/11 10:54 下午
 */
public class Test1 {

    static {
        System.out.println("这是静态代码块，最先执行");
    }

    {
        System.out.println("这是构造代码块，不是构造函数，" +
                "是每次在执行构造函数的时候会执行，但是会在构造函数之前就执行");
    }
    public Test1(){
        Set<Integer> data = new HashSet<>();
        System.out.println("这是构造函数");
    }

}
