package com.shenxu.zuul.shenxu;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shen_xu
 * @date 2021/4/12 12:55 上午
 */
public class Demo1 {


    public static void main(String[] args) {


        StringBuilder res = new StringBuilder("123");
        res.reverse();

        String dd = "11 222";

        // 输入一个int的数字，按照从右到左的的阅读顺序输出一个不含重复数据的新的数字

        // 为什么减去48  是 ascii "5"对应的是 码是 53， -48 刚好得到为数字5 转换的过程

//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(s);
//        System.out.println(s.charAt(5));
//        //因为要返回一个不含重复数字的新整数，这里我们要对已经有的数做出表示，且最多只有10个数字
//        //这里我们创建一个长度为10的数组
//        int[] arr = new int[10];
//        for (int i = s.length() - 1; i >=0; i--) {
//            if (arr[s.charAt(i) - 48] == 0) {
//                System.out.print(s.charAt(i)-48);
//                arr[s.charAt(i) - 48]++;
//            }
//        }

        // 数字倒叙
//        test1();

        // 统计字符出现的次数 并替换
//        test2();

        // 两数只和
//        test4();

//        test5();

//        test6();
//        test7();
        test8();
    }

    /**
     * 将数字到序
     */
    private static void test1() {
        // 用队列来实现
        String a = "123445";
        // 最多就是10
        ArrayQueue<Character> queue = new ArrayQueue<Character>(10);

        for (int i = a.length() - 1; i >= 0; i--) {
            if (!queue.contains(a.charAt(i))) {
                queue.add(a.charAt(i));
            }
        }
        System.out.println("--" + queue.toString());
    }

    /**
     * 找出字符串中A,用B代替，并统计A出现的次数
     */
    public static void test2() {
        String a = "AAAHHHGAGGFAHH";
        int res = 0;
        char[] j = new char[a.length() - 1];
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == 'A') {
                res++;
                j[i] = 'B';
            } else {
                j[i] = a.charAt(i);
            }
        }
        System.out.println(j);
        System.out.println(res);
    }

    /**
     * 初始化数组的方法
     */
    public static void test3() {
        int[] a = {1, 2, 3, 4, 5};
        Float[][] e = new Float[4][];

        char[][] r = {{'2', '3', '4', '5'}, new char[3]};
    }

    /**
     * 求数组中两个数的和 等于目标数 然后输出两个数的下标 默认只存在一种结果
     */
    public static void test4() {
        int[] num = {2, 7, 10, 11, 13};
        int target = 18;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length - 1; i++) {
            if (map.containsKey(target - num[i])) {
                System.out.println("两数之和");
                System.out.println(map.get(target - num[i]));
                System.out.println(i);
            } else {
                map.put(num[i], i);
            }
        }
    }

    /**
     * 二维有序数组 求目标值在数组中是否有相同的值
     */
    public static void test5() {
        int[][] matrix = {{1, 1}};
        int target = 2;
        boolean numberIn2DArray = findNumberIn2DArray(matrix, target);
        System.out.println(numberIn2DArray);
    }

    /**
     * 将字符串中的空格替换成 %20
     */
    public static void test6() {
        String s = "pp oo ii";
        System.out.println(s.replace(" ", "%20"));

        StringBuilder stringBuilder = new StringBuilder(s.length());
        System.out.println(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());

    }

    /**
     * 减绳子
     */
    public static void test7() {
        int n = 10;
        if (n <= 3) {
            System.out.println(n - 1);
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            System.out.println(Math.pow(3, a));
        } else if (b == 1) {
            System.out.println(Math.pow(3, a - 1) * 4);
        } else {
            System.out.println(Math.pow(3, a) * 2);
        }
    }

    public static void test8() {


        // 真的就这么笨吗 这都不会
        int a = 0, b = 1;
        int sum = 0;
        for (int i = 0; i < 1; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        System.out.println(a);
    }

    /**
     * test()5
     *
     * @param matrix
     * @param target
     * @return
     */
    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 思路 因为是有序的 从右上角开始 大于就往下移  小于就往左移
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }


}
