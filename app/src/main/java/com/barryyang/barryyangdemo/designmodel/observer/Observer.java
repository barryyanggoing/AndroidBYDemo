package com.barryyang.barryyangdemo.designmodel.observer;

/**
 * 观察者
 */
public abstract class Observer {

    protected Observable observable;

    public abstract void update();
}
