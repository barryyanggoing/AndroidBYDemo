package com.barryyang.barryyangdemo.bitmap.adapter;

import android.graphics.Bitmap;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barryyang.barryyangdemo.bitmap.LruCacheAsyncTask;
import com.barryyang.barryyangdemo.bitmap.viewholder.LruCacheViewHolder;
import com.barryyang.barryyangdemo.utils.LruCacheUtils;

import java.util.ArrayList;

/**
 * @author : BarryYang
 * @date : 2020/7/28 8:25 PM
 * @desc :
 */
public class LruCacheAdapter extends RecyclerView.Adapter {

    private ArrayList<String> list = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return LruCacheViewHolder.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LruCacheViewHolder lruCacheViewHolder = (LruCacheViewHolder) holder;
        String url = list.get(position);
        Bitmap fromCache = LruCacheUtils.getInstance().getBitmapFromCache(url);
        if (fromCache != null) {
            lruCacheViewHolder.imageView.setImageBitmap(fromCache);
        } else {
            LruCacheAsyncTask lruCacheAsyncTask = new LruCacheAsyncTask();
            lruCacheAsyncTask.execute(url);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDataList(ArrayList<String> lists) {
        list.addAll(lists);
        notifyDataSetChanged();
    }
}
