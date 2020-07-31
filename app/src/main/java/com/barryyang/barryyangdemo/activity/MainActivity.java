package com.barryyang.barryyangdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.glide.GlideActivity;
import com.barryyang.barryyangdemo.handler.HandlerActivity;
import com.barryyang.barryyangdemo.http.HttpActivity;
import com.barryyang.barryyangdemo.java.JavaActivity;
import com.barryyang.barryyangdemo.view.CustomActivity;
import com.barryyang.barryyangdemo.stream.StreamActivity;
import com.barryyang.barryyangdemo.bitmap.BitmapActivity;
import com.barryyang.barryyangdemo.bitmap.LruCacheActivity;
import com.barryyang.barryyangdemo.service.TargetServiceActivity;

import rxjava.RxJavaActivity;

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
        startActivity(new Intent(this, LifecycleActivity.class));
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
     *
     * @param view
     */
    public void jumpStream(View view) {
        startActivity(new Intent(this, StreamActivity.class));
    }

    /**
     * java相关
     *
     * @param view
     */
    public void jumpJava(View view) {
        startActivity(new Intent(this, JavaActivity.class));
    }

    /**
     * handler
     *
     * @param view
     */
    public void jumpHandler(View view) {
        startActivity(new Intent(this, HandlerActivity.class));
    }

    /**
     * Thread
     *
     * @param view
     */
    public void jumpThread(View view) {
        startActivity(new Intent(this, ThreadActivity.class));
    }

    /**
     * http
     *
     * @param view
     */
    public void jumpHttp(View view) {
        startActivity(new Intent(this, HttpActivity.class));
    }

    /**
     * RxJava
     * @param view
     */
    public void jumpRxJava(View view) {
        startActivity(new Intent(this, RxJavaActivity.class));
    }

    /**
     * Glide
     * @param view
     */
    public void jumpGlide(View view) {
        startActivity(new Intent(this, GlideActivity.class));
    }
}