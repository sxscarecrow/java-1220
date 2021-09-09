package com.shenxu.zuul.shenxu;

/**
 * 单例模式
 *
 * @author shen_xu
 * @date 2021/7/10 5:28 下午
 */
public class Singleton {

    public static Singleton singleton = null;
    private Singleton(){

    }
    static{
        singleton = new Singleton();
    }

    public static Singleton getSingleton(){
        return singleton;
    }

    public static Singleton singleton1 = null;

    public static Singleton singleton1(){
        if (singleton1 == null){
            synchronized (Singleton.class){
                if (singleton1 == null){
                    singleton1 = new Singleton();
                }
            }
        }
        return singleton1;
    }


}
