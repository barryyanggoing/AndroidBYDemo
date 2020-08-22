package com.barryyang.barryyangdemo.designmodel.singleton;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author barryyang
 * @desc 单例模式
 * @date 2020-06-21
 */
public class Singleton {

    private static final String TAG = "Singleton";

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public void singleMethod() {
        LogUtil.printLogDebug(TAG, "单例模式");
    }
}
