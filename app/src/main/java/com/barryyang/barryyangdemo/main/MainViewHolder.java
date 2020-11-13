package com.barryyang.barryyangdemo.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/11/13 3:59 PM
 * @desc :
 */
public class MainViewHolder extends RecyclerView.ViewHolder {

    public Button textView;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_title);
    }


    public static RecyclerView.ViewHolder createRecyclerViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main_item, parent, false);
        return new MainViewHolder(view);
    }
}
