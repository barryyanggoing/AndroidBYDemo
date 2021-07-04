package com.xigua.lrucache_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xigua.lrucache_demo.libcore.io.DiskLruCache;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : BarryYang
 * @date : 2021/7/4 12:56 下午
 * @desc :
 */
public class PhotoWallAdapter extends RecyclerView.Adapter<PhotoWallViewHolder> {

    /**
     * 记录所有正在下载的task
     */
    private final Set<BitmapWorkerTask> mBitmapTaskSet;

    /**
     * 图片缓存的核心，用于缓存所有下载好的图片，在程序内存达到设定值时会将最少最近使用的图片移除掉
     */
    private final LruCache<String, Bitmap> mMemoryCache;

    /**
     * 图片硬盘缓存核心类
     */
    private DiskLruCache mDiskLruCache;

    /**
     * 每个item的高度
     */
    private int mItemHeight;

    private final RecyclerView mRecyclerView;

    public PhotoWallAdapter(Context context, RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        mBitmapTaskSet = new HashSet<>();
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount();
            }
        };
        File cacheFile = getDiskCacheDir(context);
        if (!cacheFile.exists()) {
            cacheFile.mkdirs();
        }
        try {
            mDiskLruCache = DiskLruCache.open(cacheFile, 1, 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public PhotoWallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PhotoWallViewHolder.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoWallViewHolder holder, int position) {
        String url = Images.IMAGE_THUMB_URLS[position];
        ImageView ivPhoto = holder.mIvPhoto;
        if (ivPhoto.getLayoutParams().height != mItemHeight) {
            ivPhoto.getLayoutParams().height = mItemHeight;
        }
        ivPhoto.setTag(url);
        ivPhoto.setImageResource(R.drawable.ic_launcher_foreground);
        loadBitmaps(ivPhoto, url);
    }

    @Override
    public int getItemCount() {
        return Images.IMAGE_THUMB_URLS.length;
    }

    public Bitmap getBitmapFromMemoryCache(String url) {
        return mMemoryCache.get(url);
    }

    public void addBitmapToMemoryCache(String url, Bitmap bitmap) {
        if (getBitmapFromMemoryCache(url) == null) {
            mMemoryCache.put(url, bitmap);
        }
    }

    private void loadBitmaps(ImageView ivPhoto, String url) {
        Bitmap bitmapFromMemoryCache = getBitmapFromMemoryCache(url);
        if (bitmapFromMemoryCache == null) {
            BitmapWorkerTask bitmapWorkerTask = new BitmapWorkerTask();
            mBitmapTaskSet.add(bitmapWorkerTask);
            bitmapWorkerTask.execute(url);
        } else {
            ivPhoto.setImageBitmap(bitmapFromMemoryCache);
        }
    }

    public void cancleTask() {
        if (mBitmapTaskSet != null && mBitmapTaskSet.size() > 0) {
            for (BitmapWorkerTask task : mBitmapTaskSet) {
                task.cancel(false);
            }
        }
    }

    public File getDiskCacheDir(Context context) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + "thumb");
    }

    public void setItemHeight(int height) {
        if (mItemHeight == height) {
            return;
        }
        this.mItemHeight = height;
        notifyDataSetChanged();
    }

    /**
     * 将缓存记录同步到journal文件中。
     */
    public void flushCache() {
        if (mDiskLruCache != null) {
            try {
                mDiskLruCache.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {

        /**
         * 图片的URL地址
         */
        private String imageUrl;

        @Override
        protected Bitmap doInBackground(String... params) {
            imageUrl = params[0];
            FileDescriptor fileDescriptor = null;
            FileInputStream fileInputStream = null;
            DiskLruCache.Snapshot snapShot = null;
            try {
                // 生成图片URL对应的key
                final String key = hashKeyForDisk(imageUrl);
                // 查找key对应的缓存
                snapShot = mDiskLruCache.get(key);
                if (snapShot == null) {
                    // 如果没有找到对应的缓存，则准备从网络上请求数据，并写入缓存
                    DiskLruCache.Editor editor = mDiskLruCache.edit(key);
                    if (editor != null) {
                        OutputStream outputStream = editor.newOutputStream(0);
                        if (downloadUrlToStream(imageUrl, outputStream)) {
                            editor.commit();
                        } else {
                            editor.abort();
                        }
                    }
                    // 缓存被写入后，再次查找key对应的缓存
                    snapShot = mDiskLruCache.get(key);
                }
                if (snapShot != null) {
                    fileInputStream = (FileInputStream) snapShot.getInputStream(0);
                    fileDescriptor = fileInputStream.getFD();
                }
                // 将缓存数据解析成Bitmap对象
                Bitmap bitmap = null;
                if (fileDescriptor != null) {
                    bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                }
                if (bitmap != null) {
                    // 将Bitmap对象添加到内存缓存当中
                    addBitmapToMemoryCache(params[0], bitmap);
                }
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileDescriptor == null && fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            // 根据Tag找到相应的ImageView控件，将下载好的图片显示出来。
            ImageView imageView = mRecyclerView.findViewWithTag(imageUrl);
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            mBitmapTaskSet.remove(this);
        }

        private boolean downloadUrlToStream(String urlString, OutputStream outputStream) {
            HttpURLConnection urlConnection = null;
            BufferedOutputStream out = null;
            BufferedInputStream in = null;
            try {
                final URL url = new URL(urlString);
                urlConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(urlConnection.getInputStream(), 8 * 1024);
                out = new BufferedOutputStream(outputStream, 8 * 1024);
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
                return true;
            } catch (final IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    public String hashKeyForDisk(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    private String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

}
