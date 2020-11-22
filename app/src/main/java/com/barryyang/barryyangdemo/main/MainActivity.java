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
        list.add(new PublishInfo(PublishType.PT_LIFECYCLE, "Activity"));
        list.add(new PublishInfo(PublishType.PT_SERVICE, "Service"));
        list.add(new PublishInfo(PublishType.PT_BROADCAST, "BroadcastReceiver"));
        list.add(new PublishInfo(PublishType.PT_VIEW, "View"));
        list.add(new PublishInfo(PublishType.PT_BITMAP, "Bitmap"));
        list.add(new PublishInfo(PublishType.PT_LRUCHCHE, "LruCache"));
        list.add(new PublishInfo(PublishType.PT_STREAM, "Stream"));
        list.add(new PublishInfo(PublishType.PT_JAVA, "Java"));
        list.add(new PublishInfo(PublishType.PT_HANDLER, "Handler消息机制"));
        list.add(new PublishInfo(PublishType.PT_THREAD, "Thread"));
        list.add(new PublishInfo(PublishType.PT_HTTP, "Http"));
        list.add(new PublishInfo(PublishType.PT_RXJAVA, "RxJava"));
        list.add(new PublishInfo(PublishType.PT_GLIDE, "Glide"));
        list.add(new PublishInfo(PublishType.PT_COMPONENTS, "Components"));
        list.add(new PublishInfo(PublishType.PT_ANDROIDQ, "Android Q适配"));
        list.add(new PublishInfo(PublishType.PT_KOTLIN, "Kotlin"));
        list.add(new PublishInfo(PublishType.PT_CRASH, "Crash"));
        list.add(new PublishInfo(PublishType.PT_DESIGNMODEL, "设计模式"));
        list.add(new PublishInfo(PublishType.PT_CONSTRAINTLAYOUT, "ConstraintLayout"));
        list.add(new PublishInfo(PublishType.PT_MOTIONLAYOUT, "MotionLayout"));
        list.add(new PublishInfo(PublishType.PT_DEVICE_INFO, "设备标识"));
        list.add(new PublishInfo(PublishType.PT_OKHTTP, "OkHttp"));
        list.add(new PublishInfo(PublishType.PT_WORKMANAGER, "WorkManager"));
        list.add(new PublishInfo(PublishType.PT_NOTIFICATION, "Notification"));
        list.add(new PublishInfo(PublishType.PT_WINDOW, "Window"));
        mainAdapter.setDataList(list);
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);
    }

}