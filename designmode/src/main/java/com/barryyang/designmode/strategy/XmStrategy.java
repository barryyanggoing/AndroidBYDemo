package com.barryyang.designmode.strategy;

public class XmStrategy implements Strategy {

    @Override
    public void doYouWant() {
        System.out.println("我想吃饭");
    }
}
