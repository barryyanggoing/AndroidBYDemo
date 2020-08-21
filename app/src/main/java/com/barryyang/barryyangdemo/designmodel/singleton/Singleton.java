package com.barryyang.barryyangdemo.designmodel.singleton;

/**
 * @author barryyang
 * @desc 单例模式
 * @date 2020-06-21
 */
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

}
