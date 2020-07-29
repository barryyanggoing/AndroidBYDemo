package com.barryyang.barryyangdemo.designmodel.factory;

/**
 * 黑人
 */
public class BlackHuman implements IHuman {

    @Override
    public void getHumanColor() {
        System.out.println("黑色");
    }

    @Override
    public void humanTalk() {
        System.out.println("English");
    }
}
