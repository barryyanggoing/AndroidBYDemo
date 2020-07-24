package com.barryyang.barryyangdemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author : BarryYang
 * @date : 2020/7/24 4:00 PM
 * @desc :
 * IntentService是Service的子类,由于Service里面不能做耗时的操作,所以Google提供了IntentService,在IntentService内维护了一个工作线程来处理耗时操作，
 * 当任务执行完后，IntentService会自动停止。
 * 另外，可以启动IntentService多次，而每一个耗时操作会以工作队列的方式在IntentService的onHandleIntent回调方法中执行，
 * 并且，每次只会执行一个工作线程，执行完第一个再执行第二个，以此类推。
 */
public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, bundle.getString("key", "默认值") + ",当前线程名称：" + Thread.currentThread().getName());
            }
        }
    }
}
