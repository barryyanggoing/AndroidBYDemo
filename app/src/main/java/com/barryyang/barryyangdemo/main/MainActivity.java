package com.barryyang.barryyangdemo.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;
import com.xigua.aidldemo.AidlService;
import com.xigua.aidldemo1.IMyBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试各种
 *
 * @author barryyang
 */
public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;


    ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        connection = new MyServiceConnection();
        Intent intent = new Intent(this, AidlService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
        LogUtil.printLogDebug("任务栈id" + getTaskId());
    }

    private static class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IMyBinder iMyBinder = (IMyBinder) service;
            try {
                iMyBinder.testAidl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
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
        list.add(new PublishInfo(PublishType.PT_ANIMATION, "动画"));
        list.add(new PublishInfo(PublishType.PT_DEMO, "Demo"));
        list.add(new PublishInfo(PublishType.PT_SINGLE_TASK, "任务栈"));
        mainAdapter.setDataList(list);
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);
    }

}