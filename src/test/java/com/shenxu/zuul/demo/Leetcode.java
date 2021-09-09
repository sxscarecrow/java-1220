package com.shenxu.zuul.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author shen_xu
 * @date 2021/5/26 11:33 下午
 */
public class Leetcode {
    public static void main(String[] args) {
        jj();
        hh();
        str();
        StringBuilder stringBuilder = new StringBuilder();
        int n = 10;
        while (n != 0){
            stringBuilder.append(n % 2);
            n = n / 2;
        }
        System.out.println("二进制：" + stringBuilder.reverse());

    }

    /**
     * 求其二进制中1的个数
     */
    public static void jj(){
        int n = 33;
        String s = Integer.toBinaryString(n);
        System.out.println("jj二进制->" + s);
        int res = 0;
        while (n != 0){
            res += n&1;
            n >>= 1;
        }
        System.out.println(res);
    }

    /**
     * 数组中基数排在前面
     */
    public static void hh(){
        int[] nums = {1,2,3,4};
        int low = 0, fast = 0, tmp;
        while(fast < nums.length){
            if((nums[fast]&1) != 0){
                tmp = nums[low];
                nums[low] = nums[fast];
                nums[fast] = tmp;
                low++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 字符串中 只出现一次的第一个字符
     */
    public static void str(){
        String str = "qwerrtqw";
        char[] chars = str.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : chars){
            map.put(c, !map.containsKey(c));
        }
        for (char c :chars){
            if (map.get(c)){
                System.out.println("只出现一次的第一个字符为：" + c);
            }
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
