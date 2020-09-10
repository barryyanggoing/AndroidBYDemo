package com.barryyang.barryyangdemo.android.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/7/24 2:38 PM
 * @desc :
 */
public class LocalService extends Service {

    private static final String TAG = "LocalService";

    private int startId;

    private MediaPlayer mediaPlayer;
    private MyBinder myBinder;

    public enum Control {

        /**
         * 播放
         */
        PLAY,

        /**
         * 暂停
         */
        PAUSE,

        /**
         * 停止
         */
        STOP
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + Thread.currentThread().getName());
        mediaPlayer = MediaPlayer.create(this, R.raw.payment_dialog_open_voice);
        mediaPlayer.setLooping(true);
        myBinder = new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        this.startId = startId;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Control control = (Control) extras.getSerializable("Key");
            if (control != null) {
                switch (control) {
                    case PLAY:
                        play();
                        break;
                    case STOP:
                        stop();
                        break;
                    default:
                        pause();
                        break;
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void play() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        stopSelf(startId);
    }

    public void bindStop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return myBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind: ");
    }

    public class MyBinder extends Binder {

        public LocalService getService() {
            return LocalService.this;
        }
    }
}
