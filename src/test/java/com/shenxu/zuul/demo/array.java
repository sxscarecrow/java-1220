package com.shenxu.zuul.demo;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shen_xu
 * @date 2021/6/10 12:54 上午
 */
public class array {
    /**
     * 删除数组指定下标的元素 并将之后的元素依次向前移动
     */
    @Test
    public void demo1(){
        int index = 0;
        int[] data = {1,2,3,4,5,6};
        int[] res = new int[data.length-1];
        System.arraycopy(data, 0, res, 0, index);
        System.arraycopy(data, index+1, res, index, data.length - index - 1);
        System.out.println(Arrays.toString(res));
    }
}
