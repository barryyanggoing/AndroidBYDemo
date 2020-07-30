package com.barryyang.barryyangdemo.thread;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/7/29 6:34 PM
 * @desc :
 */
public class CustomThread extends Thread {

    private static final String TAG = "CustomThread";

    @Override
    public void run() {
        super.run();
        LogUtil.printLogDebug(TAG, Thread.currentThread().getName());
    }
}
