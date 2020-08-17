package com.barryyang.barryyangdemo.java.generic;

/**
 * @author : BarryYang
 * @date : 2020/8/19 10:00 AM
 * @desc :泛型类
 */
public class Box<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

}
