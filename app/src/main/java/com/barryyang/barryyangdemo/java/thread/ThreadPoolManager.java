package com.barryyang.barryyangdemo.java.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : BarryYang
 * @date : 2020/7/30 11:12 AM
 * @desc :线程池工具类
 */
public class ThreadPoolManager {

    private static ThreadPoolManager sThreadPoolManager;

    private ThreadPoolExecutor mThreadPoolExecutor;

    public static ThreadPoolManager getInstance() {
        if (sThreadPoolManager == null) {
            synchronized (ThreadPoolManager.class) {
                if (sThreadPoolManager == null) {
                    sThreadPoolManager = new ThreadPoolManager();
                }
            }
        }
        return sThreadPoolManager;
    }

    /**
     * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明：Executors返回的线程池对象的弊端如下：
     * 1）FixedThreadPool和SingleThreadPool:
     *   允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
     * 2）CachedThreadPool:
     *   允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。
     */
    private ThreadPoolManager() {
        mThreadPoolExecutor = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }

    public void executor(Runnable pRunnable) {
        mThreadPoolExecutor.execute(pRunnable);
    }

    public void shutDown() {
        mThreadPoolExecutor.shutdown();
    }

    public void shutDownNow() {
        mThreadPoolExecutor.shutdownNow();
    }
}
