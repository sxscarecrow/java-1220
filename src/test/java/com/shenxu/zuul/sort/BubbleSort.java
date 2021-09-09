package com.shenxu.zuul.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author shen_xu
 * @date 2021/3/16 10:52 下午
 */
public class BubbleSort {

    /*--------------------------------------------------
    *    冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，
    * 一次比较两个元素，如果它们的顺序错误就把它们交换过来。走
    * 访数列的工作是重复地进行直到没有再需要交换，也就是说该数列
    * 已经排序完成。这个算法的名字由来是因为越小的元素会经由交换
    * 慢慢“浮”到数列的顶端。
    * ---------------------------------------------------
    * 描述：
    *  1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
    *  2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
    *  3.针对所有的元素重复以上的步骤，除了最后一个；
    *  4.重复步骤1~3，直到排序完成。
    *
    * ----------------------------------------------------
    * 时间复杂度：
    *   平均：O(n的平方)
    *   最坏：O(n的平方)
    *   最优：O(n)
    *   空间复杂度：O(1)
    *   稳定性：稳定 a == b 的时候不会改变其顺序
     ----------------------------------------------------*/

    public static void main(String[] args) {
        sort();
        sort1();
        sort2();
        sort3();
        sort4();
        sort5();
        sort6();
        sort7();
        sort8();
        sort9();
        sort10();
        sort11();

        int[] array = {37, 33, 12, 3, 6, 1, 99, 17, 15, 88};

        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 比较相邻的两个元素的大小
                if (array[j] > array[j + 1]) {
                    // 交换相邻的两个元素的值
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 2021.05.26
     * 冒泡排序 第一遍
     */
    public static void sort(){
        int[] data = {22,33,1,3,5,2,12};
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length - 1 - i; j++){
                if (data[j] > data[j+1]){
                    int tmp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 2021。05。27
     * 冒泡算法第二弹
     */
    public static void sort1(){
        int[] data = {33,2,4,5,7,5,3,1};
        int tmp;
        for (int i = 0; i < data.length - 1; i++){
            for (int j = 0; j < data.length - 1 - i; j++){
                if (data[j] > data[j + 1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     *2021.06.01
     * 冒泡排序第二弹 怎么就能那么笨
     */
    public static void sort2(){
        int[] data = {2,4,5,6,33,22,44};

        int tmp;
        for (int i = 0; i < data.length; i++){
            for (int j = i; j < data.length - 1 -i; j++){
                if (data[j] > data[j+1]){
                    tmp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 2021.06.03
     * 冒泡排序第三弹
     */
    public static void sort3(){
        int[] data = {63,5,3,66,4,2,1,77, 8};
        int tmp;
        for (int i = 0; i < data.length - 1; i++){
            // 此处 -i是每次循环之后最后的数已经是最大，所以不能在去循环
            for (int j = 0; j < data.length - i - 1; j++){
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("sort3=>" + Arrays.toString(data));
    }

    /**
     * 2021.06.07
     * 冒泡排序第四弹
     */
    public static void sort4(){
        int[] data = {22,33,44,55,1,3,2,66,77};
        int tmp;
        for (int i = 0; i < data.length - 1; i++){
            for (int j = 0; j < data.length - 1 -i; j++){
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序第四弹：" + Arrays.toString(data));
    }

    /**
     * 2021.06.08
     * 冒泡排序第五弹
     * 原理：
     *  依次比较两个相邻位置的元素，并交换位置
     */
    public static void sort5(){
        int[] data = {22,33,1,4,6,77,8,35,46};
        int tmp;
        for (int i = 0; i < data.length - 1; i++){
            for (int j = 0; j < data.length - 1 - i; j++){
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序第五弹=》" + Arrays.toString(data));
    }

    /**
     * 2021.06.09
     * 冒泡排序第六弹
     * 我这个应该就一次就可以成功了
     */
    public static void sort6(){
        int[] data = {12,33,44,554,2,11,444,321};
        int tmp;
        for (int i = 0; i < data.length - 1; i++){
            for (int j = 0; j < data.length - 1 - i; j++){
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序第七弹->" + Arrays.toString(data));
    }

    /**
     * 2021.06.10
     * 冒泡排序第七弹
     * 这次应该不能在错了吧
     */
    public static void sort7(){
        int[] data = {133,55,66,88,99,33,45,23,1,3,6,3};
        int tmp;
        for (int i = 0; i < data.length - 1; i ++){
            for (int j = 0; j < data.length - 1 - i; j++){
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序第七弹->" + Arrays.toString(data));
    }

    /**
     * 2021.06.11
     * 冒泡排序第八弹 这次应该是没有问题了吧
     */
    public static void sort8(){
        int[] data = {1,3,44,2,33,55,66,54};
        int tmp;
        for (int i = 0; i < data.length - 1; i++){
            for (int j = 0; j < data.length - 1 -i; j++){
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序第八弹->" + Arrays.toString(data));
    }

    /**
     * 2021.06.17
     * 冒泡排序第九弹 我就不相信了还会有问题
     */
    public static void sort9(){
        int[] data = {2,11,44,22,33,56,75,67};
        int tmp;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序第九弹：" + Arrays.toString(data));
    }

    /**
     * 2021.06.17
     * 冒泡排序第十弹 这次应该能够写出来了吧
     */
    public static void sort10(){
        int[] data = {2,4,5,6,23,32,12,24,12};
        int tmp;
        for (int i = 0; i < data.length-1; i++) {
            for (int j = 0; j < data.length - 1 -i; j++) {
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("BubbleSort.sort10" + Arrays.toString(data));
    }

    public static void sort11(){
        int[] data = {2,4,2,1,4,55,33,23,44,5};
        int tmp;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j+1]){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("data = " + Arrays.toString(data));
    }

//    public class ChineseYuanUtil {
//
//        /**
//         * 不考虑分隔符的正确性
//         */
//        private static final Pattern AMOUNT_PATTERN = Pattern.compile("^(0|[1-9]\\d{0,11})\\.(\\d\\d)$");
//        private static final char[] RMB_NUMS = "零壹贰叁肆伍陆柒捌玖".toCharArray();
//        private static final String[] UNITS = { "元", "角", "分", "整" };
//        private static final String[] U1 = { "", "拾", "佰", "仟" };
//        private static final String[] U2 = { "", "万", "亿" };
//
//        /**
//         * 将金额（整数部分等于或少于 12 位，小数部分 2 位）转换为中文大写形式.
//         *
//         * @param amount 金额数字
//         * @return 中文大写
//         * @throws IllegalArgumentException
//         */
//        public static String convert(String amount) throws IllegalArgumentException {
//            // 去掉分隔符
//            amount = amount.replace(",", "");
//
//            // 验证金额正确性
//            if (amount.equals("0.00")) {
//                throw new IllegalArgumentException("金额不能为零.");
//            }
//            Matcher matcher = AMOUNT_PATTERN.matcher(amount);
//            if (!matcher.find()) {
//                throw new IllegalArgumentException("输入金额有误.");
//            }
//
//            // 整数部分
//            String integer = matcher.group(1);
//            // 小数部分
//            String fraction = matcher.group(2);
//
//            String result = "";
//            if (!integer.equals("0")) {
//                // 整数部分
//                result += integer2rmb(integer) + UNITS[0];
//            }
//            if (fraction.equals("00")) {
//                // 添加[整]
//                result += UNITS[3];
//            } else if (fraction.startsWith("0") && integer.equals("0")) {
//                // 去掉分前面的[零]
//                result += fraction2rmb(fraction).substring(1);
//            } else {
//                // 小数部分
//                result += fraction2rmb(fraction);
//            }
//
//            return result;
//        }
//
//        /**
//         * 将金额小数部分转换为中文大写
//         * @param fraction
//         * @return
//         */
//        private static String fraction2rmb(String fraction) {
//            // 角
//            char jiao = fraction.charAt(0);
//            // 分
//            char fen = fraction.charAt(1);
//            return (RMB_NUMS[jiao - '0'] + (jiao > '0' ? UNITS[1] : ""))
//                    + (fen > '0' ? RMB_NUMS[fen - '0'] + UNITS[2] : "");
//        }
//
//        /**
//         * 将金额整数部分转换为中文大写
//         * @param integer
//         * @return
//         */
//        private static String integer2rmb(String integer) {
//            StringBuilder buffer = new StringBuilder();
//            // 从个位数开始转换
//            int i, j;
//            for (i = integer.length() - 1, j = 0; i >= 0; i--, j++) {
//                char n = integer.charAt(i);
//                if (n == '0') {
//                    // 当 n 是 0 且 n 的右边一位不是 0 时，插入[零]
//                    if (i < integer.length() - 1 && integer.charAt(i + 1) != '0') {
//                        buffer.append(RMB_NUMS[0]);
//                    }
//                    // 插入[万]或者[亿]
//                    if (j % 4 == 0) {
//                        if (i > 0 && integer.charAt(i - 1) != '0' || i > 1 && integer.charAt(i - 2) != '0'
//                                || i > 2 && integer.charAt(i - 3) != '0') {
//                            buffer.append(U2[j / 4]);
//                        }
//                    }
//                } else {
//                    if (j % 4 == 0) {
//                        // 插入[万]或者[亿]
//                        buffer.append(U2[j / 4]);
//                    }
//                    // 插入[拾]、[佰]或[仟]
//                    buffer.append(U1[j % 4]);
//                    // 插入数字
//                    buffer.append(RMB_NUMS[n - '0']);
//                }
//            }
//            return buffer.reverse().toString();
//        }
//    }

}
