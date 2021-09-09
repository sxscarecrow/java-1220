package com.shenxu.zuul.Xiaomi;

import org.junit.Test;

/**
 * @author shen_xu
 * @date 2021/6/18 1:24 上午
 */
public class Second {
    /**
     * 2021.06.18
     * 最大子序列的和
     * 算是勉强写出来 自己是真的笨
     */
    @Test
    public void sum(){
        int[] data = {1,2,3,4,-9,6};
        int[] dp = new int[data.length];
        dp[0] = data[0];
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (dp[i-1] > 0){
                dp[i] = dp[i - 1] + data[i];
            }else {
                dp[i] = data[i];
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println("max = " + max);

    }

    /**
     * 2021.06.20 中午
     * 复习第一遍 我也不知道能不能写出来 但是自己努力一下吧 也许还真的可以吧
     * 加油吧 生活还是得继续 不然也没得什么办法 看看别人都是什么高学历什么的
     * 自己真的是普通了不能在普通的傻子
     *
     * 最大子序列求和 复习第一遍  明天在来复习一边
     */
    @Test
    public void sum1(){
        int[] data = {1,3,4,5,-7,4};
        int[] dp = new int[data.length];
        dp[0] = data[0];
        int max = data[0];

        for (int i = 1; i < data.length; i++) {
            if (dp[i-1] > 0){
                dp[i] = dp[i-1] + data[i];
            }else{
                dp[i] = data[i];
            }
            max = Math.max(dp[i], max);
        }
        System.out.println("max->sum1 = " + max);
    }
}
