package com.barryyang.barryyangdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author : BarryYang
 * @date : 2020/8/5 2:10 PM
 * @desc :
 */
public class PreferenceUtil {

    private static final String PREFS_NAME = "barryyangdemo.pref";

    private static PreferenceUtil sPreferenceUtil;

    private SharedPreferences mSharedPreferences;

    private PreferenceUtil(Context pContext) {
        mSharedPreferences = pContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static PreferenceUtil getInstance(Context pContext) {
        if (sPreferenceUtil == null) {
            synchronized (PreferenceUtil.class) {
                if (sPreferenceUtil == null) {
                    sPreferenceUtil = new PreferenceUtil(pContext);
                }
            }
        }
        return sPreferenceUtil;
    }

    /**
     * 获取Int值
     *
     * @param key
     * @return
     */
    public int getIntegerByKey(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    /**
     * 设置Int值
     *
     * @param key
     * @param value
     */
    public void setIntegerByKey(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public static final class PrefKey {

        /**
         * crash次数
         */
        public static String PREF_KEY_CRASH_COUNT = "pref_key_crash_count";
    }
}
