package com.barryyang.barryyangdemo.designmodel.strategy;

public class XmStrategy implements Strategy {

    @Override
    public void doYouWant() {
        System.out.println("我想吃饭");
    }
}
