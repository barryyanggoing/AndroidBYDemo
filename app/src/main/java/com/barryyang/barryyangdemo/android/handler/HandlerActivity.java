package com.barryyang.barryyangdemo.android.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.lang.ref.WeakReference;

/**
 * @author : BarryYang
 * @date : 2020/7/29 2:06 PM
 * @desc :handler
 */
public class HandlerActivity extends AppCompatActivity {

    private static final String TAG = "HandlerActivity";

    private static final int START_DOWNLOAD = 0;
    private static final int FINISH_DOWNLOAD = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
    }

    public void download(View view) {
        new MyThread().start();
    }

    private final MyHandler myHandler = new MyHandler(this);

    private static class MyHandler extends Handler {

        private final WeakReference<HandlerActivity> weakReference;

        public MyHandler(HandlerActivity handlerActivity) {
            weakReference = new WeakReference<>(handlerActivity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            HandlerActivity handlerActivity = weakReference.get();
            if (handlerActivity != null) {
                switch (msg.what) {
                    case START_DOWNLOAD:
                        LogUtil.printLogDebug(TAG, "START_DOWNLOAD" + Thread.currentThread().getName());
                        break;
                    case FINISH_DOWNLOAD:
                        LogUtil.printLogDebug(TAG, "FINISH_DOWNLOAD" + Thread.currentThread().getName());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            LogUtil.printLogDebug(TAG, "run()" + Thread.currentThread().getName());
            myHandler.sendEmptyMessage(START_DOWNLOAD);
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            myHandler.sendEmptyMessage(FINISH_DOWNLOAD);
        }
    }
}
