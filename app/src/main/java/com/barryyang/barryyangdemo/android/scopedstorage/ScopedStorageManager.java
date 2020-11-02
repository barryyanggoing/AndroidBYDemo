package com.barryyang.barryyangdemo.android.scopedstorage;

import android.os.Build;
import android.os.Environment;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/10/30 11:51 AM
 * @desc :
 */
public class ScopedStorageManager {

    private static final String TAG = "ScopedStorageManager";

    private static class SingletonHolder {
        private static final ScopedStorageManager INSTANCE = new ScopedStorageManager();
    }

    private ScopedStorageManager() {
    }

    public static ScopedStorageManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String readFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return new AndroidQStorageImpl().readFile();
        }
        return new LegacyExternalStorageImpl().readFile();
    }

    public void createFile() {
        //boolean externalStorageLegacy = Environment.isExternalStorageLegacy();
       // LogUtil.printLogDebug(TAG, "是否可访问旧目录：" + externalStorageLegacy);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            new AndroidQStorageImpl().createFile();
        }
        new LegacyExternalStorageImpl().createFile();
    }

    public void writeFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            new AndroidQStorageImpl().writeFile();
        }
        new LegacyExternalStorageImpl().writeFile();
    }

    public void transfer(){

    }
}
