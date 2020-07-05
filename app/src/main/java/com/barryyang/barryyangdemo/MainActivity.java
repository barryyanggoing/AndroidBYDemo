package com.barryyang.barryyangdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.barryyang.volumeview.VolumeGroup;

import java.security.PublicKey;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final int COUNT = 3;

    MyAdapter myAdApter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add("sadasdasdas");
        }
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new TestAdapter(list));

//        VolumeGroup volumeGroup = findViewById(R.id.xx);
//        volumeGroup.addVolumeView();

//        RecyclerView recyclerView = findViewById(R.id.rv_list);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                int itemViewType = myAdApter.getItemViewType(position);
//                return itemViewType == 1 ? 2 : 1;
//            }
//        });
//        //mRecyclerView.addItemDecoration(addItemDecoration());
//        recyclerView.setLayoutManager(gridLayoutManager);
//        myAdApter = new MyAdapter();
//        recyclerView.setAdapter(myAdApter);
//        setData();
    }

//    private void setData() {
//        ArrayList<ItemInfo> list = new ArrayList<>();
//        for (int i = 0; i < COUNT; i++) {
//            int viewType = getViewType(COUNT, i);
//            list.add(new ItemInfo(viewType, "第" + i + "个item"));
//        }
//        myAdApter.setDataList(list);
//    }
//
//    private int getViewType(int size, int pos) {
//        if (size == 4) {
//            return 2;//占半列的样式
//        } else if (size == 3) {
//            if (pos == 0) {
//                return 1;//占一列的样式
//            }
//            return 2;//占
//        }
//        return 1;
//    }

    public class TestAdapter extends RecyclerView.Adapter {
        List<String> list;

        public TestAdapter(List<String> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class TestViewHolder extends RecyclerView.ViewHolder {

            public TestViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }


}