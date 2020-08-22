package com.barryyang.barryyangdemo.designmodel.factory.method_factory;

/**
 * 黄种人
 */
public class YellowHuman implements IHuman {

    @Override
    public void getHumanColor() {
        System.out.println("黄色");
    }

    @Override
    public void humanTalk() {
        System.out.println("中国话");
    }
}
