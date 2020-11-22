package com.barryyang.barryyangdemo.java.thread;

import java.util.concurrent.Callable;

/**
 * @author : BarryYang
 * @date : 2020/11/20 10:42 PM
 * @desc :
 */
public class ThreadDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

    }
}
