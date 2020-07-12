package com.barryyang.designmode.factory;

/**
 * 黄种人
 */
public class YellowHuman implements IHuman{

    @Override
    public void getHumanColor() {
        System.out.println("黄色");
    }

    @Override
    public void humanTalk() {
        System.out.println("中国话");
    }
}
