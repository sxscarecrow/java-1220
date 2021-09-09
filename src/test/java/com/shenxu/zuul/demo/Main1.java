package com.shenxu.zuul.demo;

import java.util.Scanner;

/**
 * @author shen_xu
 * @date 2021/7/18 3:09 下午
 */
public class Main1 {

    public static void main(String[] args) {

        String s1 = Integer.toOctalString(16);
        System.out.println("s1 = " + s1);

        System.out.println(String.format("%08o", 16));

//        Scanner sc =new Scanner(System.in);
//
//        String line = sc.nextLine();
//        String[] str = line.split(" ");
//        Integer.MAX_VALUE

        StringBuffer s = new StringBuffer();
        int n = 257;
        String ai;
        char []bb = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            s = s.append(bb[n%16]);
            n = n/16;
        }
        ai = s.reverse().toString();
        System.out.println("jjj" + ai);

        System.out.println("---" + Integer.parseInt("10", 16));

        int i2 = Integer.parseInt("11", 16);
        System.out.println("i2 = " + i2);
        System.out.println("Integer.toBinaryString(256) = " + Integer.toBinaryString(256));

        String line = "3 4 256 257 258 259 260 261 262 263 264 265";
        String[] str = line.split(" ");

        int c = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        int num = 0;


        for (int i = 2; i < str.length; i++) {
            int data = 0;

            for (int j = 0; j < 4; j++) {

                int a = 0;
                String substring = Integer.toBinaryString(Integer.parseInt(str[i])).substring(a, a + 2);
                System.out.println("substring = " + substring);
                a = a+3;

                int i1 = Integer.parseInt(substring, 2);
                data += i1;
            }

            if (data % b < c){
                num++;
            }
        }
        System.out.println(num);
    }
}
