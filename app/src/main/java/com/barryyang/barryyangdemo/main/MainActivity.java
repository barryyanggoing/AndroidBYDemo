package com.barryyang.barryyangdemo.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.barryyang.barryyangdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试各种
 *
 * @author barryyang
 */
public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        List<PublishInfo> list = new ArrayList<>();
        list.add(new PublishInfo(PublishType.PT_LIFECYCLE, "Activity生命周期"));
        list.add(new PublishInfo(PublishType.PT_SERVICE, "Service生命周期"));
        list.add(new PublishInfo(PublishType.PT_BROADCAST, "广播相关"));
        list.add(new PublishInfo(PublishType.PT_VIEW, "view相关"));
        list.add(new PublishInfo(PublishType.PT_BITMAP, "bitmap相关"));
        list.add(new PublishInfo(PublishType.PT_LRUCHCHE, "LruCache"));
        list.add(new PublishInfo(PublishType.PT_STREAM, "输入输出流"));
        list.add(new PublishInfo(PublishType.PT_JAVA, "java相关"));
        list.add(new PublishInfo(PublishType.PT_HANDLER, "handler消息机制"));
        list.add(new PublishInfo(PublishType.PT_THREAD, "Thread相关"));
        list.add(new PublishInfo(PublishType.PT_HTTP, "http相关"));
        list.add(new PublishInfo(PublishType.PT_RXJAVA, "RxJava相关"));
        list.add(new PublishInfo(PublishType.PT_GLIDE, "Glide相关"));
        list.add(new PublishInfo(PublishType.PT_COMPONENTS, "Components"));
        list.add(new PublishInfo(PublishType.PT_ANDROIDQ, "Android Q适配"));
        list.add(new PublishInfo(PublishType.PT_KOTLIN, "kotlin相关"));
        list.add(new PublishInfo(PublishType.PT_CRASH, "crash"));
        list.add(new PublishInfo(PublishType.PT_DESIGNMODEL, "设计模式"));
        list.add(new PublishInfo(PublishType.PT_CONSTRAINTLAYOUT, "ConstraintLayout"));
        list.add(new PublishInfo(PublishType.PT_MOTIONLAYOUT, "MotionLayout"));
        list.add(new PublishInfo(PublishType.PT_DEVICE_INFO, "设备标识"));
        list.add(new PublishInfo(PublishType.PT_OKHTTP, "okhttp"));
        list.add(new PublishInfo(PublishType.PT_WORKMANAGER, "workmanager"));
        mainAdapter.setDataList(list);
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);
    }

}