package com.shenxu.zuul.threadsDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author shen_xu
 * @date 2021/6/25 9:02 下午
 */
public class Demo1 {
    static class thread{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("我没有理解错的话，这就是几个线程到达零界点的时候输出的");
            }
        });
    }

    public static void main(String[] args) {

        System.out.println("最后的返回值");
    }
}
