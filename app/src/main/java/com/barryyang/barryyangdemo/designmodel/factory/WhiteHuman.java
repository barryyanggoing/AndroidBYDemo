package com.barryyang.barryyangdemo.designmodel.factory;

public class WhiteHuman implements IHuman {

    @Override
    public void getHumanColor() {
        System.out.println("白色");
    }

    @Override
    public void humanTalk() {
        System.out.println("不知道什么鸟语");
    }
}
