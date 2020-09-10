package com.barryyang.barryyangdemo.android.bitmap.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/7/28 8:26 PM
 * @desc :
 */
public class LruCacheViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public LruCacheViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.iv_lruche);
    }

    public static RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lrucache_item, parent, false);
        return new LruCacheViewHolder(view);
    }
}
