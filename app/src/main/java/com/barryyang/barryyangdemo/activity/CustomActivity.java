package com.barryyang.barryyangdemo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/7/27 11:50 AM
 * @desc :自定义view
 */
public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }
}
