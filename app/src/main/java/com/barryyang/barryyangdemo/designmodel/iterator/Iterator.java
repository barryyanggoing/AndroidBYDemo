package com.barryyang.barryyangdemo.designmodel.iterator;

/**
 * @author : BarryYang
 * @date : 2021/9/16 5:44 下午
 * @desc :
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();
}
