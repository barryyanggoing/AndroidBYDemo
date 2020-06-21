package com.barryyang.designmode.singleton;

/**
 * @author barryyang
 * @desc 单例模式
 * @date 2020-06-21
 */
public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public Singleton getSingleton() {
        return instance;
    }

    public String getDesignModeName(){
        return "单例模式";
    }
}
