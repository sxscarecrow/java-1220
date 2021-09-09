package com.shenxu.zuul.find;

import org.junit.Test;

/**
 * @author shen_xu
 * @date 2021/6/9 1:42 上午
 */
public class Dichotomy {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6};
        int res = 3;
        int left = 0, right = data.length - 1;
        while (left < right){
            int m = (left + right) / 2;
            if (data[m] > res){
                left = m + 1;
            }
            if (data[m] < m){
                right = m - 1;
            }
            if (data[m] == res){
                System.out.println("找到了");
                return;
            }
        }
        System.out.println("没有");
    }

    @Test
    public void find(){
        int[] nums = {0,1,2,3,4,5,7,8,9};
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        System.out.println(i);
        System.out.println(j);

    }
}
