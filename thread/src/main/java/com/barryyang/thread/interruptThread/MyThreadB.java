package com.barryyang.thread.interruptThread;

/**
 * author : BarryYang
 * date   : 2020/7/22 3:46 PM
 * desc   :
 * version:
 */
public class MyThreadB extends Thread {

    private SynchronizedObject synchronizedObject;

    public MyThreadB(SynchronizedObject synchronizedObject) {
        super();
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
        super.run();
        synchronizedObject.methodB();
    }
}
