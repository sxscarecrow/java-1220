package com.shenxu.zuul.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shen_xu
 * @date 2021/6/2 1:34 上午
 */
public class Str {
    public static void main(String[] args) {

        // 最长不重复字串
        combine("abc");
        // 判断字符串是否为回文字符串
        checkHuiWen("qq");
        // 求一个数组不连续的和的最大值
        int[] nums = {1, 2, 4, 1, 7, 8, 3};
        // 1. 递归
        System.out.println("递归求数组不联系元素和的最大值->" + rec_array_sum(nums, nums.length - 1));

        // 2.动态规划
        System.out.println("动态规划求数组不联系元素和的最大值->" + dp_array_sum(nums));

        // 斐波那锲
        System.out.println("斐波那契递归 ->" + feibo(4, "rec"));
        System.out.println("斐波那契动态规划 ->" + feibo(4, "dp"));

        // 数组连续和最大值
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("递归数组连续和最大值->" + lianxu_arr_sum(arr, arr.length - 1));
    }


    // 暴力解最长不重复字串
    public static void combine(String str) {
        if (str == null)  //如果字符串为空，则直接返回
            return;
        int length = str.length();
        StringBuilder sb = new StringBuilder();  //创建字符串容器
        for (int i = 0; i < length; i++) {
            combination(str, 0, i, sb);
        }
    }

    public static void combination(String str, int index, int number, StringBuilder sb) {
        if (number == -1) {
            System.out.println(sb.toString());
            return;
        }
        if (index == str.length())
            return;
        sb.append(str.charAt(index));  //向StringBuilder中添加元素
        combination(str, index + 1, number - 1, sb);
        sb.deleteCharAt(sb.length() - 1);  //在StringBuilder中删除元素
        combination(str, index + 1, number, sb);
    }

    // 判断一个字符串是否为回文字符串
    public static void checkHuiWen(String str){

        int left = 0, right = str.length() - 1;
        boolean flag = true;
        while (left < right){
            if (str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else {
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println(str + "是回文字符串");
        }else {
            System.out.println(str + "不是回文字符串");
        }
    }

    // 递归求数组的不联系的最大值
    public static int rec_array_sum(int[] nums, int i){
        long start = System.currentTimeMillis();
        if (i == 0){
            return nums[0];
        }
        if (i == 1){
            return Math.max(nums[0], nums[1]);
        }
        // 选择本身
        int a = rec_array_sum(nums, i - 2) + nums[i];
        // 不选择本身
        int b = rec_array_sum(nums, i -1);
        System.out.println("递归耗时=>" + (System.currentTimeMillis() - start));
        return Math.max(a, b);
    }

    // 动态规划求
    public static int  dp_array_sum(int[] nums){
        long start = System.currentTimeMillis();
        // 先创建一个数组保存值
        int[] opt = new int[nums.length];

        opt[0] = nums[0];
        opt[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++){
            opt[i] = Math.max(opt[i-2] + nums[i], opt[i-1]);
        }
        System.out.println("动态规划耗时=>" + (System.currentTimeMillis() - start));
        return opt[nums.length-1];
    }

    // 斐波那契数列
    public static int feibo(int n, String type){
        switch (type){
            case "rec":
                if (n == 0){
                    return 0;
                }
                if (n == 1){
                    return 1;
                }
                return feibo(n - 1, "rec") + feibo(n -2, "rec");
            case "dp":
                int a = 0 , b = 1, sum;
               for (int i = 0; i < n; i++){
                   sum = a + b;
                   a = b;
                   b = sum;
               }
               return a;
            default:
                return 0;
        }

    }

    // 求连续数组的最大和
    public static int lianxu_arr_sum(int[] nums, int length){
//        int length = nums.length - 1;
        if (length == 0){
            return nums[0];
        }
        if (length == 1){
            return Math.max(nums[0], nums[1]);
        }

        if (nums[length] > 0){
            return lianxu_arr_sum(nums,length - 1) + nums[length];
        }else {
           return lianxu_arr_sum(nums,length-1);
        }

    }
}
