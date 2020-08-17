package com.barryyang.barryyangdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/8/14 10:11 PM
 * @desc :
 */
public class MotionView extends View {

    private static final String TAG = "MotionView";

    public MotionView(Context context) {
        super(context);
    }

    public MotionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.printLogDebug(TAG, "motionview相对于父view的坐标:" + event.getX() + "----" + event.getY());
        LogUtil.printLogDebug(TAG, "motionview相当于坐标坐标位置:" + event.getRawX() + "----" + event.getRawY());
        return super.onTouchEvent(event);
    }
}
