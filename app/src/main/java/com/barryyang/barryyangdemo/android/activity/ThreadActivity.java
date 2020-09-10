package com.barryyang.barryyangdemo.android.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.java.thread.CustomThread;
import com.barryyang.barryyangdemo.java.thread.ThreadPoolManager;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/7/29 6:36 PM
 * @desc :线程相关
 */
public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = "ThreadActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        runThread();
        startThread();
        threadPool();
    }

    /**
     * 线程池
     */
    private void threadPool() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        Thread.sleep(2000);
                        LogUtil.printLogDebug(TAG, "当前i=" + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolManager.getInstance().executor(runnable);
    }

    /**
     * run()方法只是调用了Thread实例的run()方法而已，它仍然运行在主线程上，而start()方法会开辟一个新的线程，
     * 在新的线程上调用run()方法，此时它运行在新的线程上。
     */
    private void startThread() {
        CustomThread customThread = new CustomThread();
        customThread.start();
    }

    /**
     * run()方法只是调用了Thread实例的run()方法而已，它仍然运行在主线程上，而start()方法会开辟一个新的线程，
     * 在新的线程上调用run()方法，此时它运行在新的线程上。
     */
    private void runThread() {
        CustomThread customThread = new CustomThread();
        customThread.run();
    }
}
