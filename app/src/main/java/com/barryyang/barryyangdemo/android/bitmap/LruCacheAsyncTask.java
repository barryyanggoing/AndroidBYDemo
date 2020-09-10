package com.barryyang.barryyangdemo.android.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.barryyang.barryyangdemo.utils.LogUtil;
import com.barryyang.barryyangdemo.utils.LruCacheUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author : BarryYang
 * @date : 2020/7/28 8:19 PM
 * @desc :
 */
public class LruCacheAsyncTask extends AsyncTask<String, Integer, Bitmap> {

    private static final String TAG = "LruCacheAsyncTask";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        LogUtil.printLogDebug(TAG, "onPreExecute");
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        LogUtil.printLogDebug(TAG, "doInBackground");
        Bitmap bitmap = downloadUrlToStream(strings[0]);
        if (bitmap != null) {
            LruCacheUtils.getInstance().addBitmapToCache(strings[0], bitmap);
        }
        return bitmap;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        LogUtil.printLogDebug(TAG, "onProgressUpdate");
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        LogUtil.printLogDebug(TAG, "onPostExecute");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        LogUtil.printLogDebug(TAG, "onCancelled");
    }

    private Bitmap downloadUrlToStream(String urlString) {
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            httpURLConnection = (HttpURLConnection) urlConnection;
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            bufferedInputStream = new BufferedInputStream(inputStream, contentLength);
            return BitmapFactory.decodeStream(bufferedInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return null;
    }

}
