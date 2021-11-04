package com.barryyang.barryyangdemo.android.scopedstorage;

import android.os.Environment;

import com.barryyang.barryyangdemo.MainApplication;

import java.io.File;

/**
 * @author : BarryYang
 * @date : 2020/10/30 1:06 PM
 * @desc :
 */
public class StorageUtils {

    /**
     * 获取沙盒目录路径
     *
     * @param pType
     * @return
     */
    public static String getExternalFilePath(String pType) {
//        String state = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(state)) {
//            File baseDirFile = MainApplication.provide().getExternalFilesDir(pType);
//            if (baseDirFile != null) {
//                return baseDirFile.getAbsolutePath();
//            }
//        }
//        return MainApplication.provide().getFilesDir().getAbsolutePath();
        return null;
    }

    /**
     * 获取沙盒目录缓存文件夹
     *
     * @return
     */
    public static File getExternalCacheDir() {
//        String state = android.os.Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(state)) {
//            File externalCacheDir = MainApplication.provide().getExternalCacheDir();
//            if (externalCacheDir != null) {
//                return externalCacheDir;
//            }
//        }
//        return MainApplication.provide().getCacheDir();
        return null;
    }
}
