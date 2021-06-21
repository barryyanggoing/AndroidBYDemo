package com.barryyang.barryyangdemo.android.task;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.main.JumpUtils;
import com.barryyang.barryyangdemo.main.PublishType;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2021/6/21 10:00 下午
 * @desc :
 */
public class OtherTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
        LogUtil.printLogDebug("任务栈id" + getTaskId());
    }
}
