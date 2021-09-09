package com.shenxu.zuul.leetCode.xiaohongshu;

import java.util.*;

/**
 * @author shen_xu
 * @date 2021/8/14 6:33 下午
 */
public class Second {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println("permute = " + permute);

        // 最长不重复字串
        int abcabcbb = lengthOfLongestSubstring(" ");
        System.out.println("abcabcbb = " + abcabcbb);

        double pow = Math.pow(1, 3);

        int[][] data = {
            {1,4,7},
            {2,5,8},
            {3,6,9},
        };

        boolean b = searchMatrix(data, 5);


        int[] num = {-1,0,1,2,-1,-4};
        List<List<Integer>> sum = sum(num);
        System.out.println("sum = " + sum);

        String s = "babad";
        System.out.println("longestPalindrome(s) = " + longestPalindrome(s));
    }

    // 判断一个字符串是的最长回文字串
    private static String longestPalindrome(String s){
        int len = s.length();
        if (len < 2){
            return s;
        }

        // 最大长度
        int maxLen = 1;
        // 起使位置
        int begin = 0;

        // len - 1 的是因为最后一个字符不需要再来判断了
        for (int i = 1; i < len - 1; i++){
            for (int j = i; j < len; j++){
                if (j - i + 1 > maxLen && isPalindrome(s, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }



    // 判断字符串是否为回文串
    private static boolean isPalindrome(String str, int left, int right){
        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 动态规划
    private static String longestPalindromeV2(String s){
        int length = s.length();
        if (length < 2){
            return s;
        }

        boolean[][] dp = new boolean[length][length];
        // 对角线位置都为true
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && maxLen < j - i + 1){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // 三个数的和为0
    private static List<List<Integer>> sum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1){
            return res;
        }

        if (nums.length == 1 && nums[0] == 0){
            res.add(new ArrayList<>(nums[0]));
            return res;
        }

        if (nums.length == 2 && nums[0] + nums[1] == 0)
        {
            res.add(new ArrayList<Integer>(){
                {
                    add(nums[0]);
                    add(nums[1]);
                }
            });
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        if (nums[i] != 0 && nums[j] != 0 && nums[k] != 0){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }


    private static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col > 0){
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] > target){
                col--;
            }
            if(matrix[row][col] < target){
                row++;
            }
        }
        return false;
    }


    // 字符串不重复的最长字串
    private static int lengthOfLongestSubstring(String s){
        int max = 0;
        if (s.length() == 0){
            return max;
        }

        Set<String> res = new HashSet<>();

        StringBuilder str;
        for (int i = 0; i < s.length(); i++) {
            str = new StringBuilder();
            str.append(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                // 不包含
                if (str.indexOf(String.valueOf(s.charAt(j))) > -1){
                    break;
                }else{
                    str.append(s.charAt(j));
                }
            }
            res.add(str.toString());
        }
        for (String re : res) {
            if(re.length() > max){
                max = re.length();
            }
        }

        return max;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];

                if (sum > target){
                    min = Math.min(min, j - i + 1) ;
                }
            }
        }
        return min;
    }

    private static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        int dept = 0;

        Stack<Integer> stack = new Stack<>();
        boolean[] use = new boolean[len];
        dfs(nums, dept, len, use, stack, list);
        return list;
    }

    private static void dfs(int[] nums, int dept, int len, boolean[] use, Stack<Integer> stack, List<List<Integer>> list) {
        if (dept == len){
            list.add(new ArrayList<>(stack));
        }

        for (int i = 0; i < len; i++) {
            if (use[i]){
                continue;
            }
            stack.push(nums[i]);
            use[i] = true;
            dfs(nums, dept + 1, len, use, stack, list);
            stack.pop();
            use[i] = false;
        }
    }
}
