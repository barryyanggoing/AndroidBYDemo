package com.xigua.lrucache_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author : BarryYang
 * @date : 2021/7/4 12:57 下午
 * @desc :
 */
public class PhotoWallViewHolder extends RecyclerView.ViewHolder {

    public ImageView mIvPhoto;

    public PhotoWallViewHolder(@NonNull View itemView) {
        super(itemView);
        mIvPhoto = itemView.findViewById(R.id.iv_photo);
    }

    public static PhotoWallViewHolder createViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_photo_wall_item, parent, false);
        return new PhotoWallViewHolder(view);
    }
}
