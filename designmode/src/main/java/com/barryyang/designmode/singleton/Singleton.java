package com.barryyang.designmode.singleton;

/**
 * @author barryyang
 * @desc 单例模式
 * @date 2020-06-21
 */
public class Singleton {

    /**
     * 线程每次使用被volatile修饰的变量时，都会去堆里面拿最新的数据，保证变量的值是最新的
     */
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        //为了避免不必要的同步
        if (instance == null) {
            synchronized (Singleton.class) {
                //为了确保没有其他的线程进入到synchronized创建新的实例
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

    public String getDesignModeName() {
        return "单例模式";
    }
}
