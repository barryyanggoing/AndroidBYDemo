package com.barryyang.barryyangdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class VolumeView extends View {

    private float mOriCenterStartY;
    private float mOriCenterEndY;
    private float mOriCenterStartX;
    private float mOriCenterEndX;

    private Paint mPaint;
    private RectF mRectF;

    public VolumeView(Context context) {
        this(context, null);
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(mRectF, 5, 5, mPaint);
//        canvas.drawRoundRect();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i("barryyang.volume", w + "--" + h);
        mOriCenterStartY = 0;
        mOriCenterEndY = h;
        mOriCenterStartX = w / 2.0f - 5;
        mOriCenterEndX = w / 2.0f + 5;
        oriCenterEndY = mOriCenterEndY;
        mRectF = new RectF(mOriCenterStartX, mOriCenterStartY, mOriCenterEndX, mOriCenterEndY);
    }

    float oriCenterStartY = 0;
    float oriCenterEndY = 0;

    public void refresh() {
        if (oriCenterStartY >   60) {
            oriCenterStartY = oriCenterStartY - 5;
        } else {
            oriCenterStartY = oriCenterStartY + 5;
        }
        if (oriCenterEndY > mOriCenterEndY - 60) {
            oriCenterEndY = oriCenterEndY - 5;
        } else {
            oriCenterEndY = oriCenterEndY + 5;
        }
        Log.i("barryyang.refresh", oriCenterStartY + "-->" + oriCenterEndY);
        mRectF = new RectF(mOriCenterStartX, oriCenterStartY, mOriCenterEndX, oriCenterEndY);
        invalidate();
    }
}
