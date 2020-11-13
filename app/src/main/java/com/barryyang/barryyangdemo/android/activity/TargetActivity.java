package com.barryyang.barryyangdemo.android.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.main.MainActivity;

/**
 * @author : BarryYang
 * @date : 2020/7/23 2:53 PM
 * @desc :
 * @version:
 */
public class TargetActivity extends AppCompatActivity {

    private static final String TAG = "TargetActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        Log.d(TAG, "onCreate: ");
        if (savedInstanceState != null) {
            String barryyang = savedInstanceState.getString("barryyang");
            Log.d(TAG, "onCreate: --------" + barryyang);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putString("barryyang", "异常退出");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        String barryyang = savedInstanceState.getString("barryyang");
        Log.d(TAG, "onRestoreInstanceState: --------" + barryyang);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void jump(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * IntentFilter匹配规则：
     * 1.action的匹配要求Intent中的action存在且必须和过滤规则中的其中一个action相同。另外，action区分大小写，大小写不同字符串相同的action会匹配失败。
     * 2.Intent中如果出现了category，不管有几个category，对于每个category来说，它必须是过滤规则中已经定义了的category。
     * 当然，Intent中可以没有category，如果没有category的话，按照上面的描述，这个Intent仍然可以匹配成功。
     * 3.为什么不设置category也可以匹配呢？
     * 因为系统在调用startActivity或者startActivityResult的时候，会默认的加上android.intent.category.DEFAULT，所以在使用隐式的Intent的时候，必须在intent-filter中指定
     * android.intent.category.DEFAULT。
     *
     * @param view
     */
    public void jumpIntentFilterActivity(View view) {
        Intent intent = new Intent();
        intent.setAction("com.barryyang.barryyangdemo.IntentFilter");
        intent.addCategory("com.barryyang.barryyangdemo.IntentFilter.category");
        intent.setType("text/plain");
        startActivity(intent);
    }
}
