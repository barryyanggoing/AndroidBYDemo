package com.barryyang.algorithm.erfen_query;

/**
 * 二分查找
 *
 * @author barryyang
 */
public class ErFenQuery {

    static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public static int query(int guest) {
        int minIndex = 0;
        int maxIndex = array.length - 1;
        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            int integer = array[midIndex];
            if (guest == integer) {
                return midIndex;
            } else if (guest > integer) {
                minIndex = midIndex + 1;
            } else {
                maxIndex = midIndex - 1;
            }
        }
        return -1;
    }

    public static int query1(int guest) {
        for (Integer integer : array) {
            if (guest == integer) {
                return integer;
            }
        }
        return -1;
    }
}
