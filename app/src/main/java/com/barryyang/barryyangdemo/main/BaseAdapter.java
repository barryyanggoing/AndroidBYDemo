package com.barryyang.barryyangdemo.main;

import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : BarryYang
 * @date : 2020/11/13 3:18 PM
 * @desc :
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected final List<T> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateRecyclerViewHolder(parent, viewType);
    }

    protected abstract RecyclerView.ViewHolder onCreateRecyclerViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        onBindRecyclerViewHolder(holder, position);
    }

    protected abstract void onBindRecyclerViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setDataList(List<T> list) {
        mDataList.clear();
        mDataList.addAll(list);
    }
}
