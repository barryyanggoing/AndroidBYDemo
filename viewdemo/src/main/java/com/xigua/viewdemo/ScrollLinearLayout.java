package com.xigua.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * @author : BarryYang
 * @date : 2021/7/18 3:09 下午
 * @desc :
 */
public class ScrollLinearLayout extends LinearLayout {

    private Scroller scroller;

    public ScrollLinearLayout(Context context) {
        super(context);
        init();
    }

    public ScrollLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScrollLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.VERTICAL);
        scroller = new Scroller(getContext());
    }

    public void smoothScroll(int x) {
        int scrollX = getScrollX();
        int dex = x - scrollX;
        scroller.startScroll(scrollX, 0, dex, 0, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }
}
