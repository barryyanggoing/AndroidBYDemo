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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VolumeView extends View {

    private Paint mPaint;

    private int radius;
    private int maxHeight;
    private int margin;
    private int rectfWidth;
    private int random;
    private int recfCount = 30;
    private List<RectF> list = new ArrayList<>();

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
        maxHeight = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_40);
        margin = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_15);
        rectfWidth = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_10);
        random = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_15);
        radius = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_5);
        add();
    }

    private void add() {
        for (int i = 0; i < recfCount; i++) {
            int left = (i + 1) * margin + i * rectfWidth;
            int right = (i + 1) * (margin + rectfWidth);
            int top = new Random().nextInt(random);
            int bottom = maxHeight - top;
            Log.i("barryyang.volume", left + "--" + top + "-->" + right + "-->" + bottom);
            list.add(new RectF(left, top, right, bottom));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < list.size(); i++) {
            canvas.drawRoundRect(list.get(i), radius, radius, mPaint);
        }
    }

    public void invalidat() {
        list.clear();
        add();
        postInvalidateOnAnimation();
    }
}
