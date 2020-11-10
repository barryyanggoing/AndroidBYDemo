package com.barryyang.barryyangdemo.android.workmanager;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.barryyang.barryyangdemo.R;

import java.util.concurrent.TimeUnit;

/**
 * @author : BarryYang
 * @date : 2020/11/9 10:12 AM
 * @desc :
 */
public class WorkManagerActivity extends AppCompatActivity {

    PeriodicWorkRequest periodicWorkRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workmanager);
        periodicWorkRequest = new PeriodicWorkRequest.Builder(UploadWork.class,15, TimeUnit.MINUTES)
                .build();
    }

    public void workmanager(View view) {
        WorkManager.getInstance(this).enqueue(periodicWorkRequest);
    }
}
