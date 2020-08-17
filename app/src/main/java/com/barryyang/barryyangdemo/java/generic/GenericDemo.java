package com.barryyang.barryyangdemo.java.generic;

import java.util.List;

/**
 * @author : BarryYang
 * @date : 2020/8/19 9:56 AM
 * @desc :泛型
 */
public class GenericDemo {

    /**
     * 泛型方法
     *
     * @param x
     * @param y
     * @param <T> 类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
     * @return
     */
    public static <T extends Comparable<T>> T getMinOrMax(T x, T y) {
        T max = x;
        if (y.compareTo(x) > 0) {
            max = y;
        }
        return max;
    }

    /**
     * 泛型通配符,类型通配符一般是使用?代替具体的类型参数
     *
     * @param data
     */
    public static void getData(List<?> data) {

    }

    /**
     * 类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
     *
     * @param data
     */
    public static void getNumber(List<? extends Number> data) {

    }

}
