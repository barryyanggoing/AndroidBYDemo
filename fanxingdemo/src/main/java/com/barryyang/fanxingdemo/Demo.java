package com.barryyang.fanxingdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 类定义的时候，使用泛型
 *
 * @author barryyang
 * @date 2020-06-22
 */
public class Demo<T> {

    private T param;

    public void setParam(T param) {
        this.param = param;
    }

    public T getParam() {
        return param;
    }

    /**
     * 第一个<T>表示这个方法为泛型方法
     *
     * @param <T>
     * @return
     */
    public <T> List<T> getArrayList() {
        return new ArrayList<>();
    }

    public void showClass(T t) {
        System.out.println(t.getClass());
    }

    /**
     * ? 通配符
     *
     * @param list
     */
    public void show(List<?> list) {
        list.add(null);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    /**
     * <T extends Number> 表示传入的参数类型必须是Number或者它的子类。
     *
     * @param t
     * @param <T>
     */
    public <T extends Number> void showClassss(T t) {
        System.out.println(t.getClass());
    }
}
