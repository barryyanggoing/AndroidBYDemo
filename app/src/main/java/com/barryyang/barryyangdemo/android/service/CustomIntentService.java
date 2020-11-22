package com.barryyang.barryyangdemo.android.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;

/**
 * @author : BarryYang
 * @date : 2020/7/24 4:00 PM
 * @desc :
 * IntentService是Service的子类,由于Service里面不能做耗时的操作,所以Google提供了IntentService,在IntentService内维护了一个工作线程来处理耗时操作，
 * 当任务执行完后，IntentService会自动停止。
 * 另外，可以启动IntentService多次，而每一个耗时操作会以工作队列的方式在IntentService的onHandleIntent回调方法中执行，
 * 并且，每次只会执行一个工作线程，执行完第一个再执行第二个，以此类推。
 */
public class CustomIntentService extends JobIntentService {

    private static final String TAG = "MyIntentService";

    /**
     * Called serially for each work dispatched to and processed by the service.  This
     * method is called on a background thread, so you can do long blocking operations
     * here.  Upon returning, that work will be considered complete and either the next
     * pending work dispatched here or the overall service destroyed now that it has
     * nothing else to do.
     *
     * <p>Be aware that when running as a job, you are limited by the maximum job execution
     * time and any single or total sequential items of work that exceeds that limit will
     * cause the service to be stopped while in progress and later restarted with the
     * last unfinished work.  (There is currently no limit on execution duration when
     * running as a pre-O plain Service.)</p>
     *
     * @param intent The intent describing the work to now be processed.
     */
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
//        Bundle bundle = intent.getExtras();
//        if (bundle != null) {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
        Log.i(TAG, "当前线程名称：" + Thread.currentThread().getName());
//            }
//        }

    }

}
