package com.barryyang.barryyangdemo.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;

import com.barryyang.barryyangdemo.android.activity.LifecycleActivity;
import com.barryyang.barryyangdemo.android.activity.ThreadActivity;
import com.barryyang.barryyangdemo.android.animation.AnimationActivity;
import com.barryyang.barryyangdemo.android.bitmap.BitmapActivity;
import com.barryyang.barryyangdemo.android.bitmap.LruCacheActivity;
import com.barryyang.barryyangdemo.android.broadcast.BroadcastActivity;
import com.barryyang.barryyangdemo.android.components.ComponentsActivity;
import com.barryyang.barryyangdemo.android.constraint.ConstraintActivity;
import com.barryyang.barryyangdemo.android.crash.CrashActivity;
import com.barryyang.barryyangdemo.android.demo.DemoActivity;
import com.barryyang.barryyangdemo.android.demo.ifelse.IfElseActivity;
import com.barryyang.barryyangdemo.android.deviceinfo.DeviceInfoActivity;
import com.barryyang.barryyangdemo.android.handler.HandlerActivity;
import com.barryyang.barryyangdemo.android.motionlayout.MotionLayoutActivity;
import com.barryyang.barryyangdemo.android.notification.NotificationActivity;
import com.barryyang.barryyangdemo.android.scopedstorage.ScopedStorageActivity;
import com.barryyang.barryyangdemo.android.service.TargetServiceActivity;
import com.barryyang.barryyangdemo.android.task.OtherTaskActivity;
import com.barryyang.barryyangdemo.android.task.SingleTaskActivity;
import com.barryyang.barryyangdemo.android.view.ViewActivity;
import com.barryyang.barryyangdemo.android.window.WindowActivity;
import com.barryyang.barryyangdemo.android.workmanager.WorkManagerActivity;
import com.barryyang.barryyangdemo.designmodel.DesignModelActivity;
import com.barryyang.barryyangdemo.glide.GlideActivity;
import com.barryyang.barryyangdemo.http.HttpActivity;
import com.barryyang.barryyangdemo.java.JavaActivity;
import com.barryyang.barryyangdemo.java.stream.StreamActivity;
import com.barryyang.barryyangdemo.kotlin.demo.KotlinActivity;
import com.barryyang.barryyangdemo.okhttp.OkHttpActivity;
import com.barryyang.barryyangdemo.rxjava.RxJavaActivity;

/**
 * @author : BarryYang
 * @date : 2020/11/13 3:24 PM
 * @desc :
 */
public class JumpUtils {

    private static final SparseArray<String> PATH = new SparseArray<>();

    static {
        PATH.put(PublishType.PT_LIFECYCLE, LifecycleActivity.class.getName());
        PATH.put(PublishType.PT_SERVICE, TargetServiceActivity.class.getName());
        PATH.put(PublishType.PT_BROADCAST, BroadcastActivity.class.getName());
        PATH.put(PublishType.PT_VIEW, ViewActivity.class.getName());
        PATH.put(PublishType.PT_BITMAP, BitmapActivity.class.getName());
        PATH.put(PublishType.PT_LRUCHCHE, LruCacheActivity.class.getName());
        PATH.put(PublishType.PT_STREAM, StreamActivity.class.getName());
        PATH.put(PublishType.PT_JAVA, JavaActivity.class.getName());
        PATH.put(PublishType.PT_HANDLER, HandlerActivity.class.getName());
        PATH.put(PublishType.PT_THREAD, ThreadActivity.class.getName());
        PATH.put(PublishType.PT_HTTP, HttpActivity.class.getName());
        PATH.put(PublishType.PT_RXJAVA, RxJavaActivity.class.getName());
        PATH.put(PublishType.PT_GLIDE, GlideActivity.class.getName());
        PATH.put(PublishType.PT_COMPONENTS, ComponentsActivity.class.getName());
        PATH.put(PublishType.PT_ANDROIDQ, ScopedStorageActivity.class.getName());
        PATH.put(PublishType.PT_KOTLIN, KotlinActivity.class.getName());
        PATH.put(PublishType.PT_CRASH, CrashActivity.class.getName());
        PATH.put(PublishType.PT_DESIGNMODEL, DesignModelActivity.class.getName());
        PATH.put(PublishType.PT_CONSTRAINTLAYOUT, ConstraintActivity.class.getName());
        PATH.put(PublishType.PT_MOTIONLAYOUT, MotionLayoutActivity.class.getName());
        PATH.put(PublishType.PT_DEVICE_INFO, DeviceInfoActivity.class.getName());
        PATH.put(PublishType.PT_OKHTTP, OkHttpActivity.class.getName());
        PATH.put(PublishType.PT_WORKMANAGER, WorkManagerActivity.class.getName());
        PATH.put(PublishType.PT_NOTIFICATION, NotificationActivity.class.getName());
        PATH.put(PublishType.PT_WINDOW, WindowActivity.class.getName());
        PATH.put(PublishType.PT_ANIMATION, AnimationActivity.class.getName());
        PATH.put(PublishType.PT_DEMO, DemoActivity.class.getName());
        PATH.put(PublishType.PT_IF_ELSE, IfElseActivity.class.getName());
        PATH.put(PublishType.PT_SINGLE_TASK, SingleTaskActivity.class.getName());
        PATH.put(PublishType.PT_OTHER_TASK, OtherTaskActivity.class.getName());
    }

    private static final JumpUtils instance = new JumpUtils();

    public static JumpUtils getInstance() {
        return instance;
    }

    public void jump(Context context, int publishType) {
        Intent intent = new Intent();
        String className = PATH.get(publishType);
        if (TextUtils.isEmpty(className)) {
            throw new IllegalArgumentException("找不到对应的PT");
        }
        intent.setClassName(context, PATH.get(publishType));
        if (!(context instanceof Activity)) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
