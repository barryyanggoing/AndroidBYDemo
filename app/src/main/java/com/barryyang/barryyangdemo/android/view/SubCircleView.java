package com.barryyang.barryyangdemo.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by guokun on 2019/11/29.
 * Description: 曲线背景，上半部透明，下半部纯白
 *
 * @param
 * @return
 */
public class SubCircleView extends View {

    private Path path;
    private Paint paint;
    private int width;
    private int height;

    public SubCircleView(Context context) {
        this(context, null);
    }

    public SubCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SubCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1f);
        paint.setAntiAlias(true);

        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.clipRect(0, 0, width, height);
        path.reset();

        path.moveTo(0, 0);
        path.quadTo(width / 2, height * 2, width, 0);
        path.close();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            canvas.clipOutPath(path);
        } else {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
        canvas.drawRect(new Rect(
                0,
                0,
                width,
                height
        ), paint);
    }

}
