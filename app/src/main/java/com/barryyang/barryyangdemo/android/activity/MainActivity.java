package com.barryyang.barryyangdemo.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.android.broadcast.BroadcastActivity;
import com.barryyang.barryyangdemo.android.components.ComponentsActivity;
import com.barryyang.barryyangdemo.android.constraint.ConstraintActivity;
import com.barryyang.barryyangdemo.android.crash.CrashActivity;
import com.barryyang.barryyangdemo.android.deviceinfo.DeviceInfoActivity;
import com.barryyang.barryyangdemo.designmodel.DesignModelActivity;
import com.barryyang.barryyangdemo.glide.GlideActivity;
import com.barryyang.barryyangdemo.android.handler.HandlerActivity;
import com.barryyang.barryyangdemo.http.HttpActivity;
import com.barryyang.barryyangdemo.java.JavaActivity;
import com.barryyang.barryyangdemo.kotlin.demo.KotlinActivity;
import com.barryyang.barryyangdemo.android.motionlayout.MotionLayoutActivity;
import com.barryyang.barryyangdemo.android.scopedstorage.ScopedStorageActivity;
import com.barryyang.barryyangdemo.okhttp.OkHttpActivity;
import com.barryyang.barryyangdemo.utils.LogUtil;
import com.barryyang.barryyangdemo.android.view.ViewActivity;
import com.barryyang.barryyangdemo.java.stream.StreamActivity;
import com.barryyang.barryyangdemo.android.bitmap.BitmapActivity;
import com.barryyang.barryyangdemo.android.bitmap.LruCacheActivity;
import com.barryyang.barryyangdemo.android.service.TargetServiceActivity;

import com.barryyang.barryyangdemo.rxjava.RxJavaActivity;

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
        LogUtil.printLogDebug(TAG, "onCreate");
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
        startActivity(new Intent(this, BroadcastActivity.class));
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
        startActivity(new Intent(this, ViewActivity.class));
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
     *
     * @param view
     */
    public void jumpRxJava(View view) {
        startActivity(new Intent(this, RxJavaActivity.class));
    }

    /**
     * Glide
     *
     * @param view
     */
    public void jumpGlide(View view) {
        startActivity(new Intent(this, GlideActivity.class));
    }

    /**
     * Components
     *
     * @param view
     */
    public void jumpComponents(View view) {
        startActivity(new Intent(this, ComponentsActivity.class));
    }

    /**
     * Android Q适配
     *
     * @param view
     */
    public void jumpStorage(View view) {
        startActivity(new Intent(this, ScopedStorageActivity.class));
    }

    /**
     * kotlin
     *
     * @param view
     */
    public void jumpKotlin(View view) {
        startActivity(new Intent(this, KotlinActivity.class));
    }

    /**
     * crash
     *
     * @param view
     */
    public void jumpCrash(View view) {
        startActivity(new Intent(this, CrashActivity.class));
    }

    /**
     * 设计模式
     *
     * @param view
     */
    public void jumpDesignModel(View view) {
        startActivity(new Intent(this, DesignModelActivity.class));
    }

    /**
     * ConstraintLayout
     *
     * @param view
     */
    public void jumpConstraintLayout(View view) {
        startActivity(new Intent(this, ConstraintActivity.class));
    }

    /**
     * MotionLayout
     *
     * @param view
     */
    public void jumpMotionLayout(View view) {
        startActivity(new Intent(this, MotionLayoutActivity.class));
    }

    /**
     * deeplink
     *
     * @param view
     */
    public void jumpDeepLink(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("yayagushi://com.lazyaudio.yayagushi?action=play&pt=1&id=1431"));
            startActivity(intent);
        } catch (Exception e) {

        }
    }

    /**
     * 设备标识
     *
     * @param view
     */
    public void jumpDeviceInfo(View view) {
        startActivity(new Intent(this, DeviceInfoActivity.class));
    }

    public void okhttpRequest(View view) {
        startActivity(new Intent(this, OkHttpActivity.class));
    }
}