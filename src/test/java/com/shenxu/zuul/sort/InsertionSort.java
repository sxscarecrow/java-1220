package com.shenxu.zuul.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author shen_xu
 * @date 2021/3/17 12:55 上午
 */
public class InsertionSort {

    /*-----------------------------------------------------
    * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
    *   1.从第一个元素开始，该元素可以认为已经被排序；
    *   2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
    *   3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
    *   4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
    *   5.将新元素插入到该位置后；
    *   6.重复步骤2~5。
    *
    * ---------------------------------------------------
    *   时间复杂度：
    *   平均：O(n的平方)
    *   最坏：O(n的平方)
    *   最优：O(n)
    *   空间复杂度：O(1)
    *   稳定性：稳定 a == b 的时候不会改变其顺序
    -------------------------------------------------------*/
    public static void main(String[] args) {
        int[] array = {33, 23, 20, 56, 12, 54, 67, 1, 2, 12};
        int pre, current;
        for (int i = 1; i < array.length; i++) {
            // 确定pre的值
            pre = i - 1;
            current = array[i];
            while (pre >= 0 && current > array[pre]) {
                // 先后移
                array[pre + 1] = array[pre];
                pre--;
            }
            // 在将空出来的位置填充 这里之所以 +1 是因为在while循环中 有一个 pre--操作
            array[pre + 1] = current;
        }
        System.out.println(Arrays.toString(array));
    }
}
