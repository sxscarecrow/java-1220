package com.shenxu.zuul.Xiaomi;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author shen_xu
 * @date 2021/6/17 12:42 上午
 */
public class First {
    /**
     * 整数反转
     */
    @Test
    public void integerReversal(){
        int a = -123;
        // 1. 字符串的方式
        System.out.println("字符串的方式 ->" + new StringBuilder(String.valueOf(a)).reverse());
        // 2. 数学的方式

        int rev = 0;
        while(a != 0){

            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                System.out.println("数学的方式->" + rev);
                System.exit(0);
            }
            int d = a % 10;
            a = a / 10;
            rev = rev * 10 + d;
        }
        System.out.println("数学的方式->" + rev);
    }

    /**
     * 判断是否为回文数
     */
    @Test
    public void isPalindrome(){
        int x = 323;
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                System.out.println("该数不是回文数");
                System.exit(0);
            }
        }
        System.out.println("该数是回文数");
    }

    /**
     * 判断括号是否合法
     * 利用栈来解决
     */
    @Test
    public void isValid(){
        String str = "[{}]";

        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        // 把左括号入栈，当碰见右括号则取出
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 包含
            if (map.containsKey(c)){
                if (stack.empty() || stack.peek() != map.get(c)){
                    System.out.println("非法");
                    System.exit(0);
                }
                // 有就弹出
                stack.pop();

            }else {
                stack.push(c);
            }
        }
        System.out.println(stack.empty());
    }

    // 2021.06.17 今天的任务算是完成 明天接着复习

    /**
     * 2021.06.17 回顾第一天的算法题
     */

    /**
     * 2021.06.17 整数反转复习第一遍
     */
    @Test
    public void integerReversal_1(){
        int a = 123;
        int rev = 0;
        while (a != 0){
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE){
                System.out.println("反转越界");
                System.exit(0);
            }
            int d = a % 10;
            a = a / 10;
            rev = rev * 10 + d;
        }
        System.out.println("rev = " + rev);
    }

    /**
     * 2021.06.17 判断是否为回文数复习第一遍
     */
    @Test
    public void isPalindrome_1(){
        String str = "4321234";
        int left = 0;
        int right = str.length() - 1;
        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                System.out.println("str 不是回文 ");
                System.exit(0);
            }
            left++;
            right--;
        }
        System.out.println("str 是回文 ");
    }

    /**
     * 2021.06.17 判断括号是否有效复习第一遍
     */
    @Test
    public void isValid_1(){
        String str = "{{[[]]}}";
        if (str.length() % 2 != 0){
            System.out.println("str是非法的");
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)){
                if (stack.empty() || stack.peek() != map.get(c)){
                    System.out.println("非法的");
                    System.exit(0);
                }else {
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        System.out.println("stack.empty() = " + stack.empty());
    }

}
