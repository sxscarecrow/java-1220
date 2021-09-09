package com.shenxu.zuul.demo;

import java.util.Arrays;

/**
 * @author shen_xu
 * @date 2021/5/21 7:04 下午
 */
public class Demo {

    public static void main(String[] args) {
        // 输出正方形
        a(6);
        // 十进制转二进制
        b(-10);
        int[] c = {33,44,1,3,2,64,4};
        d(c);
        e();
        e1();
        f();
        f1();
        c();
        c1();
        c2();
        c3();
        c4();
        c5();

    }

    /**
     * 输出正方形
     * @param a
     */
    public static void a(int a){
        for (int i = 0; i < a; i++){
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < a; j++){
                if (i == 0 || i == a-1){
                    res.append(" +");
                } else if (j > 0 && j < a -1){
                    res.append("  ");
                }else {
                    res.append(" +");
                }
            }
            System.out.println(res);
        }
    }

    /**
     * 十进制转二进制
     * @return
     */
    public static void b(int a){
        StringBuilder res = new StringBuilder();
        while (a != 0){
            res.append(a%2);
            a = a /2;
        }
        System.out.println(Integer.toBinaryString(-10));

    }

    /**
     * 顺时针打印数组
     * 输出结果为 1，2，3，6，9，8，7，4，5
     */
    public static void c(){
        int[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        StringBuilder str = new StringBuilder();
        // 横向
        int a = 0, b = data[0].length - 1;
        // 纵向
        int l = 0, r = data.length - 1;

        while (true){
            // 从左到右
            for (int i = a; i <= b; i++){
                str.append(data[a][i]);
                str.append(" ");
            }
            if (++l > r){
                break;
            }
            // 从上倒下
            for (int i = l; i <= r; i++){
                str.append(data[i][b]);
                str.append(" ");
            }
            if (--b < a){
                break;
            }
            // 从右到左
            for (int i = b; i >= a; i--){
                str.append(data[r][i]);
                str.append(" ");
            }
            if (--r < l){
                break;
            }
            // 从下到上
            for (int i = r; i >= l; i--){
                str.append(data[i][a]);
                str.append(" ");
            }
            if (++a > b){
                break;
            }
        }
        System.out.println("顺时针打印数组" + str);
    }

    /**
     * 斜着打印数组 从又上开始
     * 思路 分两部分答应，先打印对角线右上，在打印又下
     *
     * 打印结果 3， 2，6，1，5，9，4，8，7
     */
    public static void c1(){
        int[][] data = {
                {1, 2, 3, 14},
                {4, 5, 6, 15},
                {7, 8, 9, 16},
                {10,11,12,13}
        };
        StringBuilder str = new StringBuilder();
        // 多少列
        int c = data[0].length;
        // 打印对角线右上 并包含对角线
        for (int i = 0; i < c; i++){
            int b = c - 1 - i;
            int r = 0;
            while( r >= 0 && r <= c - 1 && b >= 0 && b <= c -1){
                str.append(data[r][b]).append(" ");
                r++;
                b++;
            }
        }
        // 打印对角线 右下方 不包含对角线
        for (int i = 0; i < c - 1; i++){
            int m = 0; // 列
            int n = i + 1; // 行
            while( m >= 0 && m <= c - 1 && n >= 0 && n <= c -1){
                str.append(data[n][m]).append(" ");
                n++;
                m++;
            }
        }
        System.out.println("右上斜打印：" + str);
    }

    /**
     * 左上 往又下打印数组
     *
     * 分两部分打印 先打印对角线左上角(包含对角线) 然后打印对角线左下(不包含对角线)
     *
     * 输出结果为：1，2，4，3，5，7，6，8，9
     */
    public static void c2(){
        int[][] data = {
                {1, 2, 3, 14},
                {4, 5, 6, 15},
                {7, 8, 9, 16},
                {10,11,12,13}
        };
        StringBuilder str = new StringBuilder();
        // 多少列
        int c = data[0].length;
        int r = data.length; // 多少行
        // 对角线左上包含对角线
        for (int i = 0; i < c; i++){
            int a = 0;
            int b = i;
            while(a <= r -1 && b <= c -1 && b >= 0){
                str.append(data[a][b]).append(" ");
                a++;
                b--;
            }
        }
        // 对角线左下打印 不包含对角线
        for(int i = 0; i < c -1; i++){
            int m = 1 + i;
            int n = c -1;
            while (m <= r -1 && n <= c -1 && n >= 0){
                str.append(data[m][n]).append(" ");
                m++;
                n--;
            }
        }
        System.out.println("左上斜打印：" + str);
    }

    /**
     * 数组答应 对角线循环打印 从左上开始 此时数组 是个正方形
     * 还是分对角线来处理
     *
     * 输出结果：1，2，4，7，5，3，6，8，9
     */
    public static void c3(){
        int[][] data = {
                {1, 2, 3, 14},
                {4, 5, 6, 15},
                {7, 8, 9, 16},
                {10,11,12,13}
        };
        StringBuilder str = new StringBuilder();
        int c = data[0].length; // lie 对应第二个坐标
        int r = data.length; // 行 对应第一个坐标

        // 左上 包含对角线
        int a, b;
        for (int i = 0; i < c; i++){
            if (i % 2 == 0){
                a = 0; // 第一个
                b = i; // 第二个
            }else{
                a = i;
                b = 0;
            }
            while (a >= 0 && a <= c - 1 && b>= 0 && b <= r -1){
                str.append(data[b][a]).append(" ");
                if (i % 2 == 0){
                    b--;
                    a++;
                }else {
                    b++;
                    a--;
                }
            }
        }

        // 左下 不包含对角线
        int m, n;
        for (int i = 0; i < c - 1; i ++){
            if (i % 2 == 0){
                m = i + 1; // 横
                n = r - 1;
            }else{
                m = c - 1;
                n = i + 1;
            }
            while (m >= 0 && m <= c - 1 && n >= 0 && n <= r -1){
                str.append(data[n][m]).append(" ");
                if (i % 2 == 0){
                    m++;
                    n--;
                }else {
                    m--;
                    n++;
                }
            }
        }
        System.out.println("左上蛇形打印：" + str);

    }

    /**
     * 数组答应 对角线循环打印 从左上开始 此时数组 是个长方形
     * 还是分对角线来处理
     *
     * 输出结果：1，2，4，7，5，3，6，8，9
     */
    public static void c4(){
        int[][] data = {
                {1, 2, 3, 14, 17, 20, 23, 26},
                {4, 5, 6, 15, 18, 21, 24, 27},
                {7, 8, 9, 16, 19, 22, 25, 28},
        };
        StringBuilder str = new StringBuilder();
        int c = data[0].length; // lie 对应第二个坐标
        int r = data.length; // 行 对应第一个坐标

        int min = Math.min(c, r);
        int max = Math.max(c, r);

        // 左上 包含对角线
        int a, b;
        for (int i = 0; i < min; i++){
            if (i % 2 == 0){
                a = 0; // 第一个
                b = i; // 第二个
            }else{
                a = i;
                b = 0;
            }
            while (a >= 0 && a <= min - 1 && b>= 0 && b <= min -1){
                str.append(data[b][a]).append(" ");
                if (i % 2 == 0){
                    b--;
                    a++;
                }else {
                    b++;
                    a--;
                }
            }
        }

        int h, j;
        for (int i = 0; i < max - min - 1; i++){
            if (i % 2 == 0){
                h = min + i;
                j =  0;
            }else {
                h = i + 1;
                j = min - 1;
            }
            while (h >= 1 && h <= max -1 && j >= 0 && j<= min -1){
                str.append(data[j][h]).append(" ");
                if (i % 2 == 0){
                    h--;
                    j++;
                }else {
                    h++;
                    j--;
                }
            }
        }

        // 左下 不包含对角线
        int m, n;
        for (int i = 0; i < min; i ++){
            if ((i + (max - min -1)) % 2 == 0){
                m = max - 1; // 横
                n = i;
            }else{
                m = max - min + i;
                n = min - 1;
            }
            while (m >= max - min - 1 && m <= max - 1 && n >= 0 && n <= min - 1){
                str.append(data[n][m]).append(" ");
                if ((i + (max - min -1)) % 2 == 0){
                    m--;
                    n++;
                }else {
                    m++;
                    n--;
                }
            }
        }
        System.out.println("长方形左上蛇形打印 (列 > 行)：" + str);

    }

    /**
     * 数组答应 对角线循环打印 从左上开始 此时数组 是个长方形
     * 还是分对角线来处理
     *
     * 输出结果：1，2，4，7，5，3，6，8，9
     */
    public static void c5(){
        int[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10,11,12},
                {13,14,15}
        };
        StringBuilder str = new StringBuilder();
        int c = data[0].length; // lie 对应第二个坐标
        int r = data.length; // 行 对应第一个坐标

        int min = Math.min(c, r);
        int max = Math.max(c, r);

        // 左上 包含对角线
        int a, b;
        for (int i = 0; i < min; i++){
            if (i % 2 == 0){
                a = 0; // 第一个
                b = i; // 第二个
            }else{
                a = i;
                b = 0;
            }
            while (a >= 0 && a <= min - 1 && b>= 0 && b <= min -1){
                str.append(data[b][a]).append(" ");
                if (i % 2 == 0){
                    b--;
                    a++;
                }else {
                    b++;
                    a--;
                }
            }
        }

        if (c != r){
            int h, j;
            for (int i = 0; i < max - min - 1; i++){
                if (i % 2 != 0){
                    h = min + i;
                    j =  0;
                }else {
                    h = i + 1;
                    j = min - 1;
                }
                while (h >= 1 && h <= max -1 && j >= 0 && j<= min -1){
                    str.append(data[h][j]).append(" ");
                    if (i % 2 != 0){
                        h--;
                        j++;
                    }else {
                        h++;
                        j--;
                    }
                }
            }
        }

        // 左下 不包含对角线
        int m, n;
        for (int i = 0; i < min; i ++){
            if ((i + (max - min -1)) % 2 != 0){
                m = max - 1; // 横
                n = i;
            }else{
                m = max - min + i;
                n = min - 1;
            }
            while (m >= max - min - 1 && m <= max - 1 && n >= 0 && n <= min - 1){
                str.append(data[m][n]).append(" ");
                if ((i + (max - min -1)) % 2 != 0){
                    m--;
                    n++;
                }else {
                    m++;
                    n--;
                }
            }
        }
        System.out.println("长方形左上蛇形打印：（行 > 列）" + str);

    }

    // 冒泡算法
    public static void d(int[] nums){
        // 依次比较，并交换位置
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = 0; j < nums.length - 1 - i; j++){
                if (nums[j] > nums[j+1]){
                    int tmp = nums[j + 1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 输出三角形
     *  *
     *  * *
     *  * * *
     */
    public static void e(){
        int n = 5;
        for (int i = 0; i < n; i++){
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < i + 1; j++){
                str.append(" *");
            }
            System.out.println(str);
        }
    }

    /**
     * 输出空的三角形
     */
    public static void e1(){
        int n = 5;
        for (int i = 0; i < n; i++){
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < i + 1; j++){
                // 输出第一行和最后一行
                if(i == 0 || i == n-1){
                    str.append(" *");
                }else{
                    // 输出每一行的边界
                    if (j == 0 || j == i){
                        str.append(" *");
                    }else{
                        str.append("  ");
                    }
                }
            }
            System.out.println(str);
        }
    }

    /**
     * 输出三角形
     * 1.找规律输出每一行前面的空格
     * 2.然后输出每行的+
     */
    public static void f(){
        int n = 7;
        boolean flag = true;
        for (int i = 1; i < n; i ++){
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < 2*i - 1; j++){
                if (flag){
                    for (int m = 1; m < n - i; m++){
                        str.append(" ");
                    }
                }
                str.append("+");
                flag = false;
            }
            flag = true;
            System.out.println(str);
        }
    }

    /**
     * 输出空的三角形
     * 1.先找输空格规律
     * 2.输出第一行和最后一行
     * 3.输出边界
     * 4.输出中间的空格
     */
    public static void f1(){
        int n = 7;
        boolean flag = true;
        for (int i = 1; i < n; i ++){
            StringBuilder str = new StringBuilder();
            for (int j = 1; j < 2*i; j++){
                // 先输出空格
                if (flag){
                    for (int m = 1; m < n - i; m++){
                        str.append(" ");
                    }
                }
                // 第一行和最后一行
                if (i == 1 || i == n-1){
                    str.append("+");
                }else {
                    // 中间的 首位和一个 +， 中间为空的
                    if (j == 1 || j == 2*i -1){
                        str.append("+");
                    }else {
                        str.append(" ");
                    }
                }
                flag = false;
            }
            flag = true;
            System.out.println(str);
        }
    }

}
