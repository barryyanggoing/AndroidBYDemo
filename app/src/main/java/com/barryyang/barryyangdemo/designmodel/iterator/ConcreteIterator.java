package com.barryyang.barryyangdemo.designmodel.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : BarryYang
 * @date : 2021/9/16 5:45 下午
 * @desc :
 */
public class ConcreteIterator<T> implements Iterator<T> {

    private int cursor = 0;
    private List<T> list = new ArrayList<>();

    public ConcreteIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            T t = list.get(cursor);
            cursor++;
            return t;
        }
        return null;
    }
}
