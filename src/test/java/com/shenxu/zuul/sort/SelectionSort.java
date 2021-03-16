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
        int[] array = {33, 23, 20, 56, 12, 54, 67, 1, 2, 12};
        int maxIndex, tmp;
        for (int i = 0; i < array.length - 1; i++) {
            maxIndex = i;
            // 取得数组中元素最大的下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]){
                    maxIndex = j;
                }
            }
            // 讲最大值放在第i位
            tmp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }
}
