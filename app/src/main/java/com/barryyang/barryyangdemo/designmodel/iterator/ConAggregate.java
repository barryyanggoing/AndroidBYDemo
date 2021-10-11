package com.barryyang.barryyangdemo.designmodel.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : BarryYang
 * @date : 2021/9/16 5:51 下午
 * @desc :
 */
public class ConAggregate<T> implements Aggregate<T> {

    private final List<T> list = new ArrayList<>();

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator<>(list);
    }
}
