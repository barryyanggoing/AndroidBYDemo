package com.barryyang.barryyangdemo.android.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.main.MainActivity;

/**
 * @author : BarryYang
 * @date : 2020/11/20 11:07 AM
 * @desc :
 */
public class NotificationActivity extends AppCompatActivity {

    private static final String ACTION_RECEIVER = "ACTION_RECEIVER";
    private static final String EXTRA_NITIFICATION_ID = "EXTRA_NITIFICATION_ID";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void sendNotification(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent receiverIntent = new Intent(this, MyBroadcastReceiver.class);
        receiverIntent.setAction(ACTION_RECEIVER);
        receiverIntent.putExtra(EXTRA_NITIFICATION_ID, 0);
        PendingIntent receiverPendingIntent = PendingIntent.getBroadcast(this, 0, receiverIntent, 0);

        String channelId = createNotificationChannel("channelId", "channelName");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setContentTitle("通知")
                .setContentText("收到一条消息")
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.demo1, "按钮", receiverPendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                //.setProgress(100, 10, true)//添加进度条
                .setStyle(
                        //new NotificationCompat.BigPictureStyle()
                        //.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.demo1))
//                        .bigLargeIcon(null)//消息收起时展示
                        new NotificationCompat.BigTextStyle()
                                .bigText("无论是否意识到 Gradle 的存在，每位 Android 程序员都会直接或间接的与 Gradle 打交道。每当通过 Android Studio 新建一个工程时，AS 都会自动创建一个通用的目录结构，然后就可以进行开发，在 app 的 build.gradle 中添加一些依赖，点击右上角的 Sync Now")
                )
                // .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.demo1))//消息收起时展示
                //.setOngoing(true)//杀掉进程或者在代码中取消通知栏才会消失
                .setAutoCancel(true);//点击通知是否要让通知栏消失
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(100, builder.build());
    }

    /**
     * android8.0以上创建渠道id
     *
     * @param channelId
     * @param channelName
     * @return
     */
    private String createNotificationChannel(String channelId, String channelName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_LOW);
            notificationManager.createNotificationChannel(notificationChannel);
            return channelId;
        }
        return null;
    }

    /**
     * 自定义通知栏
     *
     * @param view
     */
    public void defineNotification(View view) {
        // Get the layouts to use in the custom notification
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notification_small);
        RemoteViews notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.notification_large);

        String channelId = createNotificationChannel("channelId1", "channelName1");
        // Apply the layouts to the notification
        Notification customNotification = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.demo1)
                //.setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                .setCustomBigContentView(notificationLayoutExpanded)
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(101, customNotification);
    }
}
