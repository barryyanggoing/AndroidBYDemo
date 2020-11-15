package com.barryyang.barryyangdemo.android.view;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/11/13 4:29 PM
 * @desc :
 *
 * 1.onTouchEvent onTouch从源码角度看执行顺序
 */
public class ViewDispatchActivity extends AppCompatActivity {

    DispatchView dispatchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
        initView();
    }

    private void initView() {
        dispatchView = findViewById(R.id.dispatchView);
        dispatchView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtil.printLogDebug("DispatchView", "onTouch");
                return false;
            }
        });
        dispatchView.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.printLogDebug("ViewDispatchActivity->dispatchTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.printLogDebug("ViewDispatchActivity->dispatchTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.printLogDebug("ViewDispatchActivity->dispatchTouchEvent:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.printLogDebug("ViewDispatchActivity->dispatchTouchEvent:ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.printLogDebug("ViewDispatchActivity->onTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.printLogDebug("ViewDispatchActivity->onTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.printLogDebug("ViewDispatchActivity->onTouchEvent:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.printLogDebug("ViewDispatchActivity->onTouchEvent:ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(ev);
    }

}
