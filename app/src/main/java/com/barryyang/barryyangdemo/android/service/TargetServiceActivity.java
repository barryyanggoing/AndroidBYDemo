package com.barryyang.barryyangdemo.android.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/7/24 3:31 PM
 * @desc :
 */
public class TargetServiceActivity extends AppCompatActivity {

    private int i = 1;
    private boolean isBind;

    private LocalService localService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void playMusic(View view) {
        Intent intent = new Intent("com.barryyang.barryyangdemo.local");
        intent.setPackage(getPackageName());
        Bundle bundle = new Bundle();
        bundle.putSerializable("Key", LocalService.Control.PLAY);
        intent.putExtras(bundle);
        startService(intent);
    }

    public void pauseMusic(View view) {
        Intent intent = new Intent("com.barryyang.barryyangdemo.local");
        intent.setPackage(getPackageName());
        Bundle bundle = new Bundle();
        bundle.putSerializable("Key", LocalService.Control.PAUSE);
        intent.putExtras(bundle);
        startService(intent);
    }

    public void stopMusic(View view) {
        Intent intent = new Intent("com.barryyang.barryyangdemo.local");
        intent.setPackage(getPackageName());
        Bundle bundle = new Bundle();
        bundle.putSerializable("Key", LocalService.Control.STOP);
        intent.putExtras(bundle);
        startService(intent);
    }

    public void startIntentService(View view) {
        Intent intent = new Intent(this, CustomIntentService.class);
        Bundle bundle = new Bundle();
        bundle.putString("key", "当前值：" + i++);
        intent.putExtras(bundle);
        startService(intent);
    }

    public void bindPlayMusic(View view) {
        Intent intent = new Intent("com.barryyang.barryyangdemo.local");
        intent.setPackage(getPackageName());
        Bundle bundle = new Bundle();
        bundle.putSerializable("Key", LocalService.Control.PLAY);
        intent.putExtras(bundle);
        bindService(intent, demoServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public void bindPauseMusic(View view) {
        if (isBind) {
            localService.pause();
        }
    }

    public void bindStopMusic(View view) {
        if (isBind) {
            localService.bindStop();
            unbindService(demoServiceConnection);
            isBind = false;
        }
    }

    public void bindReplayMusic(View view) {
        if (isBind) {
            localService.play();
        }
    }

    private ServiceConnection demoServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("LocalService", "onServiceConnected: ");
            LocalService.MyBinder myBinder = (LocalService.MyBinder) service;
            localService = myBinder.getService();
            localService.play();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("LocalService", "onServiceDisconnected: ");
            isBind = false;
        }
    };

}
