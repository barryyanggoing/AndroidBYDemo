package com.barryyang.barryyangdemo.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/8/14 10:30 PM
 * @desc :
 * <p>
 * 1.getMeasuredHeight和getHeight的区别？
 * 2.getRawY:触摸点距离坐标系顶部的距离,getY：触摸点距离触摸view顶部的距离,getTop：触摸view顶部距离其父view的顶部的距离
 */
public class DispatchView extends View {

    private static final String TAG = "DispatchView";

    public DispatchView(Context context) {
        this(context, null);
    }

    public DispatchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DispatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.printLogDebug("DispatchView->dispatchTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.printLogDebug("DispatchView->dispatchTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.printLogDebug("DispatchView->dispatchTouchEvent:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.printLogDebug("DispatchView->dispatchTouchEvent:ACTION_CANCEL");
                break;
        }
//        return super.dispatchTouchEvent(ev);
//        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //当前触摸位置距离坐标顶部的距离
        float rawY = ev.getRawY();
        //当前触摸位置距离当前view顶部的距离
        float y = ev.getY();
        //当前view距离父view顶部的距离
        int top = getTop();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.printLogDebug("DispatchView->onTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.printLogDebug("DispatchView->onTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.printLogDebug("DispatchView->onTouchEvent:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.printLogDebug("DispatchView->onTouchEvent:ACTION_CANCEL");
                break;
        }
//        LogUtil.printLogDebug(TAG, "onTouchEvent：" + rawY + "->" + y + "->" + top);
        return super.onTouchEvent(ev);
//        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //LogUtil.printLogDebug(TAG, "onDraw" + getHeight());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //LogUtil.printLogDebug(TAG, "onMeasure" + getHeight() + "->" + getMeasuredHeight());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        // LogUtil.printLogDebug(TAG, "onLayout" + getHeight());
    }
}
