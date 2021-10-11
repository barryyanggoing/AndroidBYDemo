package com.xigua.viewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author : BarryYang
 * @date : 2021/7/20 5:40 下午
 * @desc :
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView mTvName;

    public RecyclerViewHolder(@NonNull  View itemView) {
        super(itemView);
        mTvName = itemView.findViewById(R.id.tv_name);
    }

    public static RecyclerViewHolder create(Context context, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_recycler_item, parent, false);
        return new RecyclerViewHolder(view);
    }
}
