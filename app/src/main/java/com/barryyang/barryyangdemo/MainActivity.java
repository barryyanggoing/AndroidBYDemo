package com.barryyang.barryyangdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdApter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RecyclerView recyclerView = findViewById(R.id.rv_list);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return position == 0 ? 2 : 1;
//            }
//        });
//        //mRecyclerView.addItemDecoration(addItemDecoration());
//        recyclerView.setLayoutManager(gridLayoutManager);
//        myAdApter = new MyAdapter();
//        recyclerView.setAdapter(myAdApter);
//        setData();
        final VolumeView volumeView = findViewById(R.id.volume_view);
        volumeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeView.refresh();
            }
        });

    }

    private void setData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("第" + i + "个item");
        }
        myAdApter.setDataList(list);
    }
}