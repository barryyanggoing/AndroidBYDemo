package com.barryyang.barryyangdemo.android.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/11/13 4:29 PM
 * @desc :
 */
public class ViewDispatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
    }
}
