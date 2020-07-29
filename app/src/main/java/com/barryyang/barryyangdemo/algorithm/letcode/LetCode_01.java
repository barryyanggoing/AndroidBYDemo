package com.barryyang.barryyangdemo.algorithm.letcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数字之和为target
 */
public class LetCode_01 {

    /**
     * 方法1：时间复杂度O(n^2)
     *
     * @param array
     * @param target
     */
    public static void subTarget(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int subTarget = target - array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] == subTarget) {
                    int[] targetArray = {array[i], array[j]};
                    System.out.println("符合结果：" + Arrays.toString(targetArray));
                }
            }
        }
    }

    /**
     * 方法2：时间复杂度O(n)
     *
     * @param array
     * @param target
     */
    public static void subTarget2(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        int[] ret = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                ret[0] = map.get(target - array[i]);
                ret[1] = i;
                break;
            }
            map.put(array[i], i);
        }
        String s = Arrays.toString(ret);
        System.out.println(s);
    }
}
