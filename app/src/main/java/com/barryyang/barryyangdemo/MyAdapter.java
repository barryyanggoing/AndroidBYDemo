package com.barryyang.barryyangdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    protected List<String> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyViewHolder.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tvItem.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setDataList(ArrayList<String> list) {
        mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
        }

        public static RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new MyViewHolder(view);
        }
    }
}
