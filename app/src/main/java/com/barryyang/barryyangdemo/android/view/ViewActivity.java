package com.barryyang.barryyangdemo.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/7/27 11:50 AM
 * @desc :自定义view
 */
public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    /**
     * 自定义View
     *
     * @param view
     */
    public void defineView(View view) {
        startActivity(new Intent(this, DefineViewActivity.class));
    }

    /**
     * 事件分发
     *
     * @param view
     */
    public void eventView(View view) {
        startActivity(new Intent(this, ViewDispatchActivity.class));
    }
}
