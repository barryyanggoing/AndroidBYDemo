package com.barryyang.algorithm.maopao;

/**
 * 冒泡排序
 * 算法描述：
 * 1.比较相邻的元素，如果前一个比后一个大，就交换他们两个
 * 2.对每一个相邻元素做相同的工作，从开始第一队到结尾的最后一对,这样最后的数必定是最大的数字
 * 3.针对所有的元素重复以上的步骤，除了最后一个。
 * <p>
 * 设置一个布尔值，默认为false,如果一直为false，则说明排序完毕
 */
public class MaoPaoSort {

    public static void sort(int[] array) {
        //外层每循环一次为一轮
        for (int i = 0; i < array.length; i++) {
            boolean isSwap = false;
            //每次循环的个数减去最后的一个最大值，因为每一轮比较后最后的i个数已经是排序好了
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
