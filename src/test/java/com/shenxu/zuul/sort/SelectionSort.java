package com.shenxu.zuul.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author shen_xu
 * @date 2021/3/17 12:25 上午
 */
public class SelectionSort {

    /*---------------------------------------------
    *    选择排序(Selection-sort)是一种简单直观的排序算法。
    * 它的工作原理：首先在未排序序列中找到最小（大）元素，
    * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继
    * 续寻找最小（大）元素，然后放到已排序序列的末尾。以此类
    * 推，直到所有元素均排序完毕。
    * ----------------------------------------------
    * 算法描述：
    *   n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
    *    1.初始状态：无序区为R[1..n]，有序区为空；
    *    2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
    *      该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
    *      使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
    *    3.n-1趟结束，数组有序化了。
    * ---------------------------------------------
    * 时间复杂度：
    *  平均：O(n的平方)
    *  最坏：O(n的平方)
    *  最优：O(n的平方)
    *  空间复杂度：O(1)
    *  稳定行：不稳定 a == b 其顺序可能会改变
    *
     ----------------------------------------------*/

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

        int[] array = {33, 23, 20, 56, 12, 54, 67, 1, 2, 12};
        int maxIndex, tmp;
        for (int i = 0; i < array.length - 1; i++) {
            maxIndex = i;
            // 取得数组中元素最大的下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 将最大值放在第i位
            tmp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 2021.05.26
     * 选择排序 训练第一遍
     */
    public static void sort(){
        int[] data = {1,3,2,55,4,7,12,78,13};
        int minIndex, tmp;
        int length = data.length;
        for (int i = 0; i < length - 1; i++){ // 为什么 -1 感觉到最后一个元素的时候已经不用在判断
            // 取出最小值的下标
            minIndex = i;
            for (int j = i + 1; j < length; j++){
                if (data[j] < data[minIndex]){
                    minIndex = j;
                }
            }
            // 将最小的值后于
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 2021.05.27
     * 选择排序 训练第二遍
     */
    public  static void sort1(){
        int[] data = {11,3,4,2,44,66,33,22};
        int tmp, minIndex;
        int m = 0, n= 0;
        for (int i = 0; i < data.length - 1; i++){
            minIndex = i;
            // 找到最大的值
            for (int j = i + 1; j < data.length; j++){
                if (data[j] > data[minIndex]){
                    minIndex = j;
                }
                n++;
            }
            // 比较交换位置
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex]= tmp;
            m++;
        }
        System.out.println("sort2===>j--->" + n);
        System.out.println("sort2===>i--->" + m);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 2021.06.01
     * 选择排序第三弹  真的是不知道自己怎么就这么笨
     */
    public static void sort2(){
        int[] data = {11,3,4,2,44,66,33,22};
        int minIndex, tmp;
        int m = 0, n= 0;
        for (int i = 0; i < data.length; i++){
            minIndex = i;
            for (int j = i; j < data.length - 1; j++){
                if (data[minIndex] < data[j+1]){
                    minIndex = j + 1;
                }
                n++;

            }
            // 交换值
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
            m++;
        }
        System.out.println("sort2===>j--->" + n);
        System.out.println("sort2===>i--->" + m);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 2021.06.03
     * 选择排序第四谈 我就不相信自己真的有那么笨
     */
    public static void sort3(){
        int[] data = {22,44,11,3,5,7,5,3};
        int tmp, min;
        for (int i = 0; i < data.length - 1; i++){
            min = i;
            for (int j = i ; j < data.length; j++){
                if (data[j] < data[min]){
                    min = j;
                }
            }
            // 交换
            tmp = data[min];
            data[min] = data[i];
            data[i] = tmp;
        }
        System.out.println("选择排序第四弹-》" + Arrays.toString(data));
    }

    /**
     * 2021.06.07
     * 选择排序第五弹 人还是要多努力  自己还是太蠢了
     */
    public static void sort4(){
        int[] data = {33,22,11,4,6,33,55,88,333,1,2,4};
        int minIndex, tmp;
        for (int i = 0; i < data.length - 1; i++){
            minIndex = i;
            for (int j = i+1; j < data.length; j++){
                if (data[j] > data[minIndex]){
                    minIndex = j;
                }
            }
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println("选择排序第五弹-》" + Arrays.toString(data));
    }

    /**
     * 2021.06.08
     * 选择排序第六弹 这次我一定要写出来  自己感觉来说应该是没有什么问题了 坚持每天写一遍 加油 你又不比别人差
     * 原理：
     *  在为排序的的序列中找到一个最大或者最小的数字，放在有序序列的起使位置，
     *  然后在到未排列的数字中找到最大或者最小的数字放在已经排序的后面，依次执行
     *  到n-1个数字
     */
    public static void sort5(){
        int[] data = {1,3,4,22,55,34,23,66,56};
        int tmp, minIndex;
        for (int i = 0; i < data.length - 1; i++){
            minIndex = i;
            for (int j = i+1; j < data.length; j++){
                if (data[j] > data[minIndex]){
                    minIndex = j;

                }
            }
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println("选择排序第六弹-》" + Arrays.toString(data));

    }

    /**
     * 2021.06.09
     * 选择排序第七弹
     * 我觉得我这次一定会一次成功
     */
    public static void sort6(){
        int[] data = {33,2,4,55,66,33,44,12};
        int tmp, minIndex;
        for (int i = 0; i < data.length - 1; i++){
            minIndex = i;
            for (int j = i + 1; j < data.length; j++){
                if (data[j] > data[minIndex]){
                    minIndex = j;
                }
            }
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println("选择排序第七弹-> " + Arrays.toString(data));
    }

    /**
     * 2021.06.10
     * 选择排序第七弹 错了打自己一巴掌
     * 我就不行了第七遍了还写不出来 真的有那么笨嘛
     */
    public static void sort7(){
        int[] data = {22,44,33};
        int tmp, minIndex;
        for (int i = 0; i < data.length - 1; i++){
            minIndex = i;
            for (int j = i+1; j < data.length; j++){
                if (data[j] > data[minIndex]){
                    minIndex = j;
                }
            }
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println("选择排序第七弹->" + Arrays.toString(data));
    }

    /**
     * 2021.06.11
     * 选择排序第八弹
     * 我是真的笨 卧槽
     */
    public static void sort8(){
        int[] data = {1,44,3,2,66,77,55};
        int minIndex, tmp;
        for (int i = 0; i < data.length - 1; i++){
            minIndex = i;
            for (int j = i + 1; j < data.length; j++){
                if (data[j] > data[minIndex]){
                    minIndex = j;
                }
            }
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println("选择排序第八弹->" + Arrays.toString(data));
    }

    /**
     * 2021.06.17
     * 选择排序第九弹  这次应该是没有什么问题了吧
     */
    public static void sort9(){
        int[] data = {33,2,44,54,34,67,89,64,32};
        int tmp;
        int minIndex;
        for (int i = 0; i < data.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[minIndex]){
                    minIndex = j;
                }
            }
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println("选择排序第九弹：" + Arrays.toString(data));
    }

    /**
     * 2021.06.17
     * 选择排序第十弹 自己真的是太笨了 感觉什么都不是
     */
    public static void sort10(){
        int[] data = {2,4,5,3,44,34,35,23,32};
        int tmp, minIndex;
        for (int i = 0; i < data.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[minIndex]){
                    minIndex = j;
                }
            }
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println("SelectionSort.sort10" + Arrays.toString(data));
    }

    /**
     * 2021.07.10
     * 选择排序 第十一弹
     */
    public static void sort11(){
        int[] data = {1,23,22,12,13,6,5,99, 67};
        int minIndex, tmp;
        for (int i = 0; i < data.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[minIndex]){
                    minIndex = j;
                }
            }
            tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
        System.out.println("data = " + Arrays.toString(data));
    }
}
