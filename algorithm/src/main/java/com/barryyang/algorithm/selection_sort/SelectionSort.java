package com.barryyang.algorithm.selection_sort;

/**
 * 选择排序
 * 1 33 6 50 5 100
 * 1 5 33 6 50 100
 * ...
 * 1 5 6 33 50 100
 */
public class SelectionSort {

    private static int array[] = new int[]{33, 6, 50, 5, 1, 100};

    public static void sort() {
        //总共要经过n-1轮比较
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            //每轮比较的次数n-i
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

}
