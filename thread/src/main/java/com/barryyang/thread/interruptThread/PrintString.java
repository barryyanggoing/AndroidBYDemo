package com.barryyang.thread.interruptThread;

/**
 * author : BarryYang
 * date   : 2020/7/22 6:05 PM
 * desc   :
 * version:
 */
public class PrintString implements Runnable {

    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        try {
            Thread.sleep(50);
            isContinuePrint = continuePrint;
        } catch (Exception e) {

        }
    }

    public void printStringMethod() {
        try {
            while (isContinuePrint) {
                System.out.println("当前线程的名称" + Thread.currentThread().getName());
                //Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printStringMethod();
    }
}
