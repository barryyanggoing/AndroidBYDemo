package com.barryyang.barryyangdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<ItemInfo> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return OneViewHolder.createViewHolder(parent);
        }
        return MyViewHolder.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            OneViewHolder oneViewHolder = (OneViewHolder) holder;
            oneViewHolder.tvItem.setText(mDataList.get(position).name);
        } else {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.tvItem.setText(mDataList.get(position).name);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = mDataList.get(position).viewType;
        if (viewType == 1) {
            return 1;
        }
        return 2;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setDataList(ArrayList<ItemInfo> list) {
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

    public static class OneViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
        }

        public static RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item, parent, false);
            return new OneViewHolder(view);
        }
    }
}
