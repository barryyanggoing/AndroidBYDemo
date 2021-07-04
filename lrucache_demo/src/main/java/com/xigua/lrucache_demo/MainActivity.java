package com.xigua.lrucache_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    private PhotoWallAdapter mPhotoWallAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        mPhotoWallAdapter = new PhotoWallAdapter(this,recyclerView);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        recyclerView.setAdapter(mPhotoWallAdapter);
        mPhotoWallAdapter.setItemHeight((int) (widthPixels / 1.0f / 3));
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPhotoWallAdapter.flushCache();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        mPhotoWallAdapter.cancleTask();
    }

}