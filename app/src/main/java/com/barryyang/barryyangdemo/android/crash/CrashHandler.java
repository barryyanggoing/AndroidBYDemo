package com.barryyang.barryyangdemo.android.crash;

import android.os.Handler;
import android.os.Looper;

/**
 * @author : BarryYang
 * @date : 2020/8/5 10:31 AM
 * @desc :
 */
public class CrashHandler {

    private CrashHandlerListener mCrashHandler;

    private static CrashHandler mInstance;

    private static CrashHandler getInstance() {
        if (mInstance == null) {
            synchronized (CrashHandler.class) {
                if (mInstance == null) {
                    mInstance = new CrashHandler();
                }
            }
        }
        return mInstance;
    }

    public static void init(CrashHandlerListener crashHandler) {
        getInstance().setCrashHandler(crashHandler);
    }

    private void setCrashHandler(CrashHandlerListener crashHandler) {
        mCrashHandler = crashHandler;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        Looper.loop();
                    } catch (Throwable e) {
                        if (mCrashHandler != null) {
                            mCrashHandler.uncaughtException(Looper.getMainLooper().getThread(), e);
                        }
                    }
                }
            }
        });

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (mCrashHandler != null) {
                    mCrashHandler.uncaughtException(t, e);
                }
            }
        });

    }

    public interface CrashHandlerListener {
        void uncaughtException(Thread t, Throwable e);
    }
}
