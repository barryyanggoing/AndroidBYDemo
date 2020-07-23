package com.barryyang.barryyangdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.barryyang.barryyangdemo.activity.TestActivity;

/**
 * 测试各种
 *
 * @author barryyang
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Activity生命周期测试
     *
     * @param view
     */
    public void jump(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }
}