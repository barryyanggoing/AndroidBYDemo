package com.barryyang.barryyangdemo.main;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author : BarryYang
 * @date : 2020/11/13 3:38 PM
 * @desc :
 */
public class MainAdapter extends BaseAdapter<PublishInfo> {

    @Override
    protected RecyclerView.ViewHolder onCreateRecyclerViewHolder(ViewGroup parent, int viewType) {
        return MainViewHolder.createRecyclerViewHolder(parent);
    }

    @Override
    protected void onBindRecyclerViewHolder(final RecyclerView.ViewHolder holder, int position) {
        MainViewHolder mainViewHolder = (MainViewHolder) holder;
        final PublishInfo publishInfo = mDataList.get(position);
        mainViewHolder.textView.setText(publishInfo.getTabName());
        mainViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JumpUtils.getInstance().jump(holder.itemView.getContext(), publishInfo.getPublishType());
            }
        });
    }
}
