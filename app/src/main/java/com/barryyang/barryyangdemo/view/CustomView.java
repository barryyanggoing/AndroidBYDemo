package com.barryyang.barryyangdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/7/27 11:42 AM
 * @desc :
 */
public class CustomView extends View {

    private static final String TAG = "CustomView";

    private Paint mPaint;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        typedArray.recycle();
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        String widthModeStr = getMode(widthMode);
        String heightModeStr = getMode(widthMode);
        LogUtil.printLogDebug(TAG, "View宽度：" + widthSize + ",View的宽度绘制模式：" + widthModeStr);
        LogUtil.printLogDebug(TAG, "View高度：" + heightSize + ",View的高度绘制模式：" + heightModeStr);
        int widthMeasure = getSize(getResources().getDimensionPixelOffset(R.dimen.dimen_100), widthMode, widthSize);
        int heightMeasure = getSize(getResources().getDimensionPixelOffset(R.dimen.dimen_100), heightMode, heightSize);
        int size = Math.min(widthMeasure, heightMeasure);
        LogUtil.printLogDebug(TAG, "最终size:" + size);
        setMeasuredDimension(size, size);
    }

    private int getSize(int defaultSize, int mode, int size) {
        int resultSize = defaultSize;
        switch (mode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                resultSize = size;
                break;
            default:
                break;
        }
        return resultSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getMeasuredWidth() / 2f, getMeasuredHeight() / 2f, getMeasuredWidth() / 2f, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private String getMode(int widthMode) {
        return widthMode == MeasureSpec.AT_MOST ? "MeasureSpec.AT_MOST" : widthMode == MeasureSpec.EXACTLY ? "MeasureSpec.EXACTLY" : "MeasureSpec.UNSPECIFIED";
    }
}
