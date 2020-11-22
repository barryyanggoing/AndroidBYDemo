package com.barryyang.barryyangdemo.android.window;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/11/22 10:27 AM
 * @desc :
 */
public class WindowActivity extends AppCompatActivity {

    private WindowManager.LayoutParams layoutParams;
    private WindowManager windowManager;
    private Button inflate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);
    }

    public void addWindow(View view) {
//        View inflate = LayoutInflater.from(this).inflate(R.layout.window_alert, null);
        final ViewGroup.LayoutParams layoutParams1 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        inflate = new Button(this);
        inflate.setText("ss");
        // inflate.setLayoutParams(layoutParams1);
        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT, PixelFormat.TRANSPARENT);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        layoutParams.width = getResources().getDimensionPixelSize(R.dimen.dimen_50);
        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.dimen_50);
        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        layoutParams.type = 50;
        layoutParams.x = 0;
        layoutParams.y = 0;
        windowManager.addView(inflate, layoutParams);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WindowActivity.this, "点击window的事件", Toast.LENGTH_LONG).show();
            }
        });
        inflate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtil.printLogDebug(event.getAction() + "");
                int rawX = (int) event.getRawX();
                int rawY = (int) event.getRawY();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    LogUtil.printLogDebug("移动" + rawX + "->" + rawY);
                    layoutParams.x = rawX;
                    layoutParams.y = rawY;
                    windowManager.updateViewLayout(inflate, layoutParams);
                }
                return false;
            }
        });
    }

    public void clickWindow(View view) {
        Toast.makeText(this, "点击window以外的事件", Toast.LENGTH_LONG).show();
    }

    public void clickBtn(View view) {
        Toast.makeText(WindowActivity.this, "点击window的事件", Toast.LENGTH_LONG).show();
    }
}
