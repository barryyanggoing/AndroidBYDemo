package com.barryyang.barryyangdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.barryyang.barryyangdemo.activity.CustomActivity;
import com.barryyang.barryyangdemo.activity.StreamActivity;
import com.barryyang.barryyangdemo.activity.TestActivity;
import com.barryyang.barryyangdemo.bitmap.BitmapActivity;
import com.barryyang.barryyangdemo.bitmap.LruCacheActivity;
import com.barryyang.barryyangdemo.service.TargetServiceActivity;

/**
 * 测试各种
 *
 * @author barryyang
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Activity生命周期测试
     *
     * @param view
     */
    public void jumpActivity(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent: ");
    }

    /**
     * Service生命周期测试
     *
     * @param view
     */
    public void jumpService(View view) {
        startActivity(new Intent(this, TargetServiceActivity.class));
    }

    /**
     * 测试广播
     *
     * @param view
     */
    public void jumpBroadcast(View view) {

    }

    /**
     * 测试内容提供者
     *
     * @param view
     */
    public void jumpContentProvider(View view) {
    }

    /**
     * 自定义view
     *
     * @param view
     */
    public void jumpCustomView(View view) {
        startActivity(new Intent(this, CustomActivity.class));
    }

    /**
     * bitmap优化
     *
     * @param view
     */
    public void jumpBitmap(View view) {
        startActivity(new Intent(this, BitmapActivity.class));
    }

    /**
     * LruCache
     *
     * @param view
     */
    public void jumpLruCache(View view) {
        startActivity(new Intent(this, LruCacheActivity.class));
    }

    /**
     * 输入输出流
     * @param view
     */
    public void jumpStream(View view) {
        startActivity(new Intent(this, StreamActivity.class));
    }
}