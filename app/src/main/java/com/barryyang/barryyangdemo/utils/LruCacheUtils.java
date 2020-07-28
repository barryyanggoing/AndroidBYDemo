package com.barryyang.barryyangdemo.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * @author : BarryYang
 * @date : 2020/7/28 8:03 PM
 * @desc :
 */
public class LruCacheUtils {

    private static LruCacheUtils sLruCacheUtils;

    private LruCache<String, Bitmap> mBitmapLruCache;

    public static LruCacheUtils getInstance() {
        if (sLruCacheUtils == null) {
            synchronized (LruCacheUtils.class) {
                if (sLruCacheUtils == null) {
                    sLruCacheUtils = new LruCacheUtils();
                }
            }
        }
        return sLruCacheUtils;
    }

    private LruCacheUtils() {
        initLruCache();
    }

    private void initLruCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        mBitmapLruCache = new LruCache<String, Bitmap>(maxMemory / 8) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                //返回图片占用的字节数
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public void addBitmapToCache(String key, Bitmap bitmap) {
        if (getBitmapFromCache(key) == null) {
            mBitmapLruCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromCache(String key) {
        return mBitmapLruCache.get(key);
    }
}
