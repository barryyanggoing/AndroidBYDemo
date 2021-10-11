package com.xigua.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : BarryYang
 * @date : 2021/7/20 5:32 下午
 * @desc :
 */
public class RecyclerListView extends FrameLayout {

    private RecyclerAdapter mRecyclerAdapter;

    public RecyclerListView(@NonNull Context context) {
        super(context);
        initView();
    }

    public RecyclerListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RecyclerListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_recycler_view, this);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(mRecyclerAdapter);
    }

    public void setAdapter() {
        List<String> list = new ArrayList<>();
        list.add("小名1");
        list.add("小名2");
        list.add("小名3");
        list.add("小名4");
        list.add("小名5");
        list.add("小名6");
        list.add("小名7");
        list.add("小名8");
        mRecyclerAdapter.setDataList(list);
    }
}
