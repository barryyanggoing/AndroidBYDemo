package com.barryyang.designmode.observer;

/**
 * 观察者
 */
public abstract class Observer {

    protected Observable observable;

    public abstract void update();
}
