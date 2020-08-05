package com.barryyang.barryyangdemo.crash;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/8/5 10:29 AM
 * @desc :
 */
public class CrashActivity extends AppCompatActivity {

    private String s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
    }

    public void mainThreadCrash(View view) {
        s.equals("test");
    }

    public void threadCrash(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                s.equals("test");
            }
        }).start();
    }
}
