package com.barryyang.barryyangdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int COUNT = 3;

    MyAdapter myAdApter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int itemViewType = myAdApter.getItemViewType(position);
                return itemViewType == 1 ? 2 : 1;
            }
        });
        //mRecyclerView.addItemDecoration(addItemDecoration());
        recyclerView.setLayoutManager(gridLayoutManager);
        myAdApter = new MyAdapter();
        recyclerView.setAdapter(myAdApter);
        setData();

    }

    private void setData() {
        ArrayList<ItemInfo> list = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            int viewType = getViewType(COUNT, i);
            list.add(new ItemInfo(viewType, "第" + i + "个item"));
        }
        myAdApter.setDataList(list);
    }

    private int getViewType(int size, int pos) {
        if (size == 4) {
            return 2;//占半列的样式
        } else if (size == 3) {
            if (pos == 0) {
                return 1;//占一列的样式
            }
            return 2;//占
        }
        return 1;
    }
}