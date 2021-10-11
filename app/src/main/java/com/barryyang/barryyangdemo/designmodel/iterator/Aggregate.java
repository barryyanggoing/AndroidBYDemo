package com.barryyang.barryyangdemo.designmodel.iterator;

/**
 * @author : BarryYang
 * @date : 2021/9/16 5:50 下午
 * @desc :
 */
public interface Aggregate<T> {

    void add(T t);

    void remove(T t);

    Iterator<T> iterator();
}
