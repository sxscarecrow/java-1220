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

        int[] array = {37, 33, 12, 3, 6, 1, 99, 17, 15, 88};

        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 比较相邻的两个元素的大小
                if (array[j] > array[j+1]){
                    // 交换相邻的两个元素的值
                    tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}