package com.shenxu.zuul.Xiaomi;

import lombok.val;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author shen_xu
 * @date 2021/6/20 2:48 下午
 */
public class Third {

    /**
     * 2021.06.20 二进制求和
     * 直接转成十进制在进行求和 然后再转换成二进制
     */
    @Test
    public void addBinary(){
        String s = Integer.toBinaryString(Integer.parseInt("11", 2) +
                Integer.parseInt("11", 2));
        System.out.println("s = " + s);
    }

    /**
     * 2021.06.22 求最大公约数 approximate 和最小公倍数 multiple
     * 感觉是真的有点累
     * 计算规则：
     *  最大公约数 ：取两个值余数为0的最大值
     *  最小公倍数：最大公约数 * a / 最大公约数 * b / 最大公约数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入a:");
        int a = scanner.nextInt();

        System.out.println("输入b:");
        int b = scanner.nextInt();

        for (int i = Math.max(a, b); i > 0 ; i--) {
            if (a % i == 0 && b % i == 0){
                System.out.println("最大公约数为：" + i);
                System.out.println("最小公倍数为：" + (i * (a / i) * (b / i)));
                break;
            }
        }
    }
}
