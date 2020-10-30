package com.barryyang.barryyangdemo.utils;

import android.os.Environment;

/**
 * @author : BarryYang
 * @date : 2020/7/31 5:40 PM
 * @desc :
 */
public class Cfg {

    /**
     * 根目录（Android 10 以下）
     */
    public static final String ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/barryyangdemo";

    public static final String ROOT_STREAM_PATH = ROOT_PATH + "/stream/";
    public static final String FILE_NAME = "stream.txt";
    public static final String RANDOM_FILE_NAME = "random.txt";
    public static final String RANDOM_PATH = ROOT_STREAM_PATH + RANDOM_FILE_NAME;
    public static final String STREAM_PATH = ROOT_STREAM_PATH + FILE_NAME;

    /**
     * 分区存储
     */
    public static final String ROOT_SCOPED_PATH = ROOT_PATH + "/scopedstorage/";
    public static final String SCOPED_STORAGE_FILE_PATH = ROOT_SCOPED_PATH + "scopedstorage.txt";


}
