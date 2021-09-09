package com.shenxu.zuul.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shen_xu
 * @date 2021/6/8 12:31 上午
 * 快排  说实话 我感觉真的是懵懵的 大概思想我是理解了
 */
public class QuickSort {
    /*
    * 快速排序算法
    * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
    *   其中一部分记录的关键字均比另一部分的关键字小，则可分别对这
    *   两部分记录继续进行排序，以达到整个序列有序。
    *
    * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
    *   从数列中挑出一个元素，称为 “基准”（pivot）；
    *   重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的
    *       后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。
    *       这个称为分区（partition）操作；
    *   递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
    */

    public static void main(String[] args) {
        int[] data = {33,55,66,1,3,44,22,77,99,34,56,74};

        sort0(data, 0, data.length - 1);
        System.out.println("快速排序第一弹->" + Arrays.toString(data));
        sort1(data, 0, data.length-1);
        System.out.println("快速排序第二弹->" + Arrays.toString(data));
        sort2(data, 0, data.length-1);
        System.out.println("快速排序第三弹->" + Arrays.toString(data));

        sort3(data, 0, data.length-1);
        System.out.println("快速排序第四弹->" + Arrays.toString(data));

        sort4(data, 0, data.length-1);
        System.out.println("快速排序第五弹->" + Arrays.toString(data));

        sort5(data, 0, data.length - 1);
        System.out.println("快速排序第六弹-> = " + Arrays.toString(data));

        sort6(data, 0, data.length-1);
        System.out.println("快速排序第七弹 = " + Arrays.toString(data));

        sort7(data, 0, data.length-1);
        System.out.println("快速排序第七弹追加 = " + Arrays.toString(data));

        sort8(data, 0, data.length-1);
        System.out.println("快速排序第八弹 = " + Arrays.toString(data));

        sort9(data, 0, data.length-1);
        System.out.println("快速排序第九弹 = " + Arrays.toString(data));


    }

    /**
     * 2021.06.08
     * 快速排序第一弹  我也不知道我自己能不能写出来 感觉应该是可以
     * 感觉还是像那么回事
     *
     * @param data 要排列的数组
     * @param l 左边界
     * @param r 右边界
     */
    public static void sort0(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int pivot = data[l];
        int left = l, right = r;
        while(left < right){
            // 先从右边开始处理数据
            while (left < right && data[right] > pivot){
                // 代表右边的数据不同 下标左移
                right--;
            }
            // 右边小于 基准 左右交换位置 由于基准就是data[pivot] 所以直接覆盖掉
            if (left < right){
                data[left] = data[right];
            }

            // 处理左边
            while(left < right && data[left] < pivot){
                left++;
            }
            if (left < right){
                data[right] = data[left];
            }

            if (left >= right){
                data[left] = pivot;
            }
        }
        // 递归左边
        sort0(data, l, right - 1);
        // 递归右边
        sort0(data, right + 1, r);
    }

    /**
     * 2021.06.09
     * 快速排序第二弹 我感觉我应该可以 但是不知道能不能行 不行就多来几遍 加油
     * 也不是那么的笨嘛 别人可以的你也一定可以的 加油
     *
     * @param data 要排序的数组
     * @param l 左边界
     * @param r 右边界
     */
    public static void sort1(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int left = l, right = r;
        int pivot = data[left];

        while (left < right){
            // 先排右边
            while (left < right && pivot < data[right]){
                right--;
            }
            // 把右边的位置赋值到左边
            if (pivot > data[right]){
                data[left] = data[right];
            }

            // 排左边
            while (left < right && pivot > data[left]){
                left++;
            }

            // 把左边的位置赋值到右边
            if (pivot < data[left]){
                data[right] = data[left];
            }
            // 相遇的是就结束 将pivot赋值在这里
            if (left >= right){
                data[left] = pivot;
            }
        }
        // 递归处理左边
        sort1(data, l, right - 1);
        // 递归处理右边
        sort1(data, right+1, r);
    }

    /**
     * 2021.06.10
     * 快速排序第三弹 说实话感觉有点危险 感觉写不出来 不过应该还是能够写出来
     *
     * @param data 要排序的数组
     * @param l 左边界
     * @param r 右边界
     */
    public static void sort2(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int left = l, right = r, pivot = data[left];
        while (left < right){
            while (left < right && data[right] > pivot){
                right--;
            }
            if (data[right] < pivot){
                data[left] = data[right];
            }

            while (left < right && data[left] < pivot){
                left++;
            }
            if (data[left] > pivot){
                data[right] = data[left];
            }

            if (left >= right){
                data[left] = pivot;
            }
        }
        sort2(data, l, right - 1);
        sort2(data, right + 1, r);
    }

    /**
     * 2021.06.11
     * 快速排序第四弹 我感觉我自己是真的不适合干这个工作了
     *
     * @param data 代排序的数组
     * @param l 左边界
     * @param r 右边界
     */
    public static void sort3(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int left = l, right = r, pivot = data[l];
        while (left < right){
            while (left < right && data[right] > pivot){
                right--;
            }
            if (data[right] < pivot){
                data[left] = data[right];
            }
            while (left < right && data[left] < pivot){
                left++;
            }
            if (data[left] > pivot){
                data[right] = data[left];
            }
            if (left >= right){
                data[left] = pivot;
            }
        }
        sort3(data, l, right - 1);
        sort3(data, right + 1, r);
    }

    /**
     * 2021.06.17
     * 快速排序第四弹 我感觉我应该可以
     */
    public static void sort4(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int left = l, right = r;
        int pivot = data[left];
        while (left < right){
            // 先处理右边
            while (data[right] > pivot && left < right){
                right--;
            }
            if (data[right] < pivot){
                data[left] = data[right];
            }

            while (data[left] < pivot && left < right){
                left++;
            }

            if (data[left] > pivot){
                data[right] = data[left];
            }

            if (left >= right){
                data[left] = pivot;
            }
        }
        sort4(data, l , right-1);
        sort4(data, right+1, r);
    }

    /**
     * 2021.06.17
     * 快速排序第五弹  我也不知道我自己可不可以 反正还是不能放弃
     */
    public static void sort5(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int left = l, right = r;
        int pivot = data[left];
        while (left < right){
            while (left < right && data[right] > pivot){
                right--;
            }
            if (data[right] < pivot){
                data[left] = data[right];
            }

            while (left < right && data[left] < pivot){
                left++;
            }
            if (data[left] > pivot){
                data[right] = data[left];
            }

            if (left >= right){
                pivot = data[left];
            }
        }
        sort5(data, l , right - 1);
        sort5(data, right+1, r);
    }

    /**
     * 2021.06.24 快速排序第六弹
     * 不知道可不可以 反正要努力的试一下 假如到时候可以 就真的是转了
     * 生活也许没有你想像的那么糟 但是也没有你想像的那么好 加油吧
     */
    public static void sort6(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int left = l, right = r;
        int pivot = data[left];

        while (left < right){
            // 先右边
            while (left < right && pivot < data[right]){
                right--;
            }
            if(pivot > data[right]){
                data[left] = data[right];
            }

            // 左边
            while (left < right && pivot > data[left]){
                left++;
            }
            if( pivot < data[left]){
                data[right] = data[left];
            }

            if (left >= right){
                pivot = data[left];
            }
        }
        sort6(data, l, right - 1);
        sort6(data, right + 1, r);
    }

    /**
     * 2021.06.29 k快速排序第七弹
     * 说实话 不知道以后会怎么样 但是总归不能放弃自己
     */
    public static void sort7(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int left = l, right = r, pivot = data[left];

        while(left < right){
            // 先右边
            while (left < right && pivot < data[right]){
                right--;
            }
            if (pivot > data[right]){
                data[left] = data[right];
            }
            // 左边
            while (left < right && pivot > data[left]){
                left++;
            }
            if (pivot < data[left]){
                data[right] = data[left];
            }
            if (left >= right){
                pivot = data[left];
            }
        }
        sort7(data,l, right - 1);
        sort7(data, right+1, r);
    }


    /**
     * 2021.06.29
     * 未来怎么样谁也不知道 完全感觉不到未来 也许生活就是这样吧
     * 过一天算一天 生活就是这么的无可奈何 想改变却没有什么办法
     */
    public static void sort8(int[] data, int l, int r){
        if (l >= r){
            return;
        }
        int left = l, right = r;
        int pivot = data[left];

        while (left < right){
            while (left < right && data[right] > pivot){
                right--;
            }
            if (data[right] < pivot){
                data[left] = data[right];
            }

            while(left < right && data[left] < pivot){
                left++;
            }
            if (data[left] > pivot){
                data[right] = data[left];
            }

            if (left >= right){
                pivot = data[left];
            }
        }
        sort8(data, l, right - 1);
        sort8(data, right+1, r);
    }

    public static void sort9(int[] nums, int l, int r){
        if (l >= r){
            return;
        }

        int left = l, right = r, pivot = nums[l];

        while (left < right){
            // 先右边
            while (left < right && nums[right] > pivot){
                right--;
            }
            if (nums[right] < pivot){
                nums[left] = nums[right];
            }

            while (left < right && nums[left] < pivot){
                left++;
            }
            if (nums[left] > pivot){
                nums[right] = nums[left];
            }

            if (left >= right){
                pivot = nums[left];
            }
        }

        sort9(nums, l, right-1);
        sort9(nums, right+1, r);
    }
}
