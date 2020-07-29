package com.barryyang.barryyangdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;

/**
 * 1.TestActivity启动
 * D/TestActivity: onCreate:
 * D/TestActivity: onStart:
 * D/TestActivity: onResume:
 * <p>
 * 2.TestActivity跳转到TargetActivity
 * <p>
 * D/TestActivity: onPause:
 * D/TargetActivity: onCreate:
 * D/TargetActivity: onStart:
 * D/TargetActivity: onResume:
 * D/TestActivity: onStop:
 * <p>
 * 3.TargetActivity返回到TestActivity
 * D/TargetActivity: onPause:
 * D/TestActivity: onRestart:
 * D/TestActivity: onStart:
 * D/TestActivity: onResume:
 * D/TargetActivity: onStop:
 * D/TargetActivity: onDestroy:
 * <p>
 * 4.查看栈Activity信息adb shell dumpsys activity | grep com.barryyang.barryyangdemo
 */

/**
 * @author : BarryYang
 * @date : 2020/7/23 3:06 PM
 * @desc :
 * @version:
 */
public class LifecycleActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void jump(View view) {
        startActivity(new Intent(this, TargetActivity.class));
    }
}
