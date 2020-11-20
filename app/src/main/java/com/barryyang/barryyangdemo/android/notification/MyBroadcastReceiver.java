package com.barryyang.barryyangdemo.android.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/11/20 11:46 AM
 * @desc :
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("EXTRA_NITIFICATION_ID");
        LogUtil.printLogDebug(action + stringExtra);
    }
}
