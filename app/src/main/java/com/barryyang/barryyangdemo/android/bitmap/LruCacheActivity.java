package com.barryyang.barryyangdemo.android.bitmap;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.android.bitmap.adapter.LruCacheAdapter;

import java.util.ArrayList;

/**
 * @author : BarryYang
 * @date : 2020/7/28 6:19 PM
 * @desc :LruCache使用  AsyncTask HttpURLConnection
 */
public class LruCacheActivity extends AppCompatActivity {

    private LruCacheAdapter mLruCacheAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lrucache);
        initView();
        initData();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mLruCacheAdapter = new LruCacheAdapter();
        recyclerView.setAdapter(mLruCacheAdapter);
    }

    private void initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("http://cover.yayagushi.com/e93518e7b29d431fa934e94ffa3c1a7c_1280x672.png");
        }
        mLruCacheAdapter.setDataList(list);
    }

}
