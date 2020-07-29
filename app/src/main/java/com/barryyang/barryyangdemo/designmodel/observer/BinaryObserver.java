package com.barryyang.barryyangdemo.designmodel.observer;

public class BinaryObserver extends Observer {

    public BinaryObserver(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("更新");
    }
}
