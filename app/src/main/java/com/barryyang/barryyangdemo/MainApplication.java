package com.barryyang.barryyangdemo;

import android.app.Application;
import android.content.Context;
import com.barryyang.barryyangdemo.utils.LogUtil;
import com.barryyang.barryyangdemo.utils.PreferenceUtil;

/**
 * @author : BarryYang
 * @date : 2020/8/5 10:37 AM
 * @desc :
 */
public class MainApplication extends Application {

    private static final String TAG = "MainApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.printLogDebug(TAG, "onCreate()");
//        CrashHandler.init(new CrashHandler.CrashHandlerListener() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                LogUtil.printLogDebug(TAG, "当前线程=" + t.getName() + ",异常信息" + e.getMessage());
//                Intent intent = new Intent("com.barryyang.barryyangdemo.report");
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LogUtil.printLogDebug(TAG, "attachBaseContext()");
        int integerByKey = PreferenceUtil.getInstance(this).getIntegerByKey(PreferenceUtil.PrefKey.PREF_KEY_CRASH_COUNT, 0);
        LogUtil.printLogDebug(TAG, String.valueOf(integerByKey));
    }

}
