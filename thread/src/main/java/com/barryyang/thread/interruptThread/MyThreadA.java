package com.barryyang.thread.interruptThread;

/**
 * author : BarryYang
 * date   : 2020/7/22 3:46 PM
 * desc   :
 * version:
 */
public class MyThreadA extends Thread {

    private SynchronizedObject synchronizedObject;

    public MyThreadA(SynchronizedObject synchronizedObject) {
        super();
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
        super.run();
        synchronizedObject.methodA();
    }
}
