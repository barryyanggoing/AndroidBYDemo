package com.barryyang.barryyangdemo;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.barryyang.barryyangdemo.android.scopedstorage.DownloadFileTransfer;
import com.barryyang.barryyangdemo.android.scopedstorage.ScopedStorageManager;
import com.barryyang.barryyangdemo.utils.LogUtil;
import com.barryyang.barryyangdemo.utils.PreferenceUtil;

/**
 * @author : BarryYang
 * @date : 2020/8/5 10:37 AM
 * @desc :
 */
public class MainApplication extends Application {

    private static final String TAG = "MainApplication";

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        LogUtil.printLogDebug(TAG, "onCreate()");
        ScopedStorageManager.getInstance().createFile();
        DownloadFileTransfer.getInstance().transfer();
    }

    public static Application provide() {
        return application;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LogUtil.printLogDebug(TAG, "attachBaseContext()");
        int integerByKey = PreferenceUtil.getInstance(this).getIntegerByKey(PreferenceUtil.PrefKey.PREF_KEY_CRASH_COUNT, 0);
        LogUtil.printLogDebug(TAG, String.valueOf(integerByKey));
        MultiDex.install(this);
    }

}
