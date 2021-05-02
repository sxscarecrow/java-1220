package com.shenxu.zuul.test;

import com.shenxu.zuul.domain.result.Result;

import java.util.Objects;

/**
 * @author ly
 * @date 2020/8/20 16:16
 */

public class Object {

    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));  // 当有运算符的时候 会自动发生装箱和拆箱操作
        System.out.println(g.equals(a + b));

//        test test1 = null;
//        test test = new test(1, "3");
//        test1 = test;
//        System.out.println(test1 != null);


        String time = "2020-01~2020-02";
        String[] times = time.split("~");

        System.out.println(times[0] + "====" + times[1]);

    }


    public static class test {
        int a;
        String b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public test() {

        }

        @Override
        public String toString() {
            return "test{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    '}';
        }

        public test(int a, String b) {
            this.a = a;
            this.b = b;
        }
    }
}

