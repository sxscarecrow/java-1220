package com.shenxu.zuul.leetCode.xiaohongshu;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author shen_xu
 * @date 2021/7/23 12:21 上午
 */
public class First {

    public static void main(String[] args) {

        int[] a = {3,3,6,5,-2,2,5,1,-9,4};
        boolean b = canThreePartsEqualSumV1(a);
        System.out.println("b = " + b);

        boolean happy = isHappy(116);
        System.out.println("happy = " + happy);

    }

    /**
     * 将数组分成和相等的三部分
     *
     * 双指针的方法
     *
     * @param a 数组
     * @return
     */
    private static boolean canThreePartsEqualSumV1(int[] a){
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum % 3 != 0){
            return false;
        }

        int left = 0;
        int right = a.length - 1;
        int leftSum = a[left];
        int rightSum = a[right];

        while (right - left > 1){
            if (leftSum == (sum / 3) && rightSum == (sum / 3)){
                return true;
            }
            if (leftSum != sum / 3){
                leftSum += a[++left];
            }

            if (rightSum != sum / 3){
                rightSum += a[--right];
            }
        }
        return false;
    }

    /**
     * 快乐数 利用map来判断是否处于循环链种
     * 1.一直下去最终变为 1
     * 2.一直下去最终成为一个循环
     * 3.一直下去最终成为无穷大 这种情况可以忽略不管
     */
    private static boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = sum(n);
        }
        return n == 1;
    }


    /**
     * 求每位数的平方和
     * @param n 所求的数字
     * @return 返回对应的和
     */
    private static int sum(int n){
        int sum = 0;
        while(n > 0){
            int a = n % 10;
            sum += Math.pow(a, 2);
            n = n / 10;
        }
        return sum;
    }

    /**
     * 删除数组中的重复元素
     * 双指针方法
     */
    private static int removeDuplicates(int[] a){
        int length = a.length;
        if (length < 2){
            return length;
        }

        int low = 1, fast = 1;
        while (low < length && fast < length){
            if (a[fast] != a[fast - 1]){
                a[low] = a[fast];
                low++;
            }
            fast++;
        }
        return low;
    }

    /**
     * 验证是否为回文串
     */
    private static boolean isPalindrome(String s){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                stringBuilder.append(String.valueOf(s.charAt(i)).toUpperCase());
            }
        }
        int left = 0, right = stringBuilder.length() - 1;
        while (left <= right){
            if (stringBuilder.charAt(left) != stringBuilder.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 数组中最长回文字串
     */
    private static int maxSubArray(int[] nums){
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 0;
        int max = 0;
        for (int i = length-1; i > 0; i--) {
            if (dp[i - 1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = Math.max(dp[i-1], nums[i]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
