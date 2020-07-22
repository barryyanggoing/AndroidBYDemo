package com.barryyang.thread.interruptThread;

/**
 * author : BarryYang
 * date   : 2020/7/22 5:45 PM
 * desc   :
 * version:
 */
public class SynchronizedObject {

    public synchronized void methodA() {
        try {
            System.out.println("开始A");
            Thread.sleep(1000);
            System.out.println("结束A");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        try {
            System.out.println("开始B");
            //Thread.sleep(1000);
            //  System.out.println("结束B");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
