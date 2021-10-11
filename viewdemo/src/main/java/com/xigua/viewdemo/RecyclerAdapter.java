package com.xigua.viewdemo;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : BarryYang
 * @date : 2021/7/20 5:37 下午
 * @desc :
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final List<String> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RecyclerViewHolder.create(parent.getContext(),parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.mTvName.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setDataList(List<String> list){
        mDataList.addAll(list);
        notifyDataSetChanged();
    }

}
