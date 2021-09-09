package com.shenxu.zuul.thread;

import lombok.SneakyThrows;

/**
 * @author shen_xu
 * @date 2021/6/9 9:28 下午
 */
public class ShenxuThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId() + "===》main开始");
        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread = new MyThread("线程2");

        myThread.setPriority(2);

        myThread.start();
        myThread1.start();

        System.out.println(Thread.currentThread().getId() + " ===》 main结束");
    }

    static class MyThread extends Thread{
        @SneakyThrows
        @Override
        public void run() {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        }

        public MyThread(String name){
            super(name);
        }
    }
}
