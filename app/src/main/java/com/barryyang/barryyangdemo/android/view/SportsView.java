package com.barryyang.barryyangdemo.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author : BarryYang
 * @date : 2021/6/22 11:26 下午
 * @desc :
 */
public class SportsView extends View {

    private Paint paint;

    private float progress = 0f;

    private final RectF rectF;

    public SportsView(Context context) {
        this(context, null);
    }

    public SportsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SportsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(false);
        paint.setColor(Color.RED);
        rectF = new RectF(0, 0, 300, 300);
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public float getProgress() {
        return progress;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rectF, 135, progress * 2.7f, true, paint);
    }
}
