package com.barryyang.barryyangdemo.designmodel.strategy;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void excuteStrategy() {
        strategy.doYouWant();
    }
}
