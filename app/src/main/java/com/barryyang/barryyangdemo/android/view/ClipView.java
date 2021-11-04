package com.barryyang.barryyangdemo.android.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2021/11/3 10:02 上午
 * @desc :
 */
public class ClipView extends View {

    private Paint paint;
    private Bitmap bitmap;
    private Path path;

    public ClipView(Context context) {
        this(context, null);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        path = new Path();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.living);
    }

    int cx = 0;
    int cy = 0;
//    int width = 0;
//    int height = 0;

    private void setcx(int cx, int cy) {
        this.cx = cx;
        this.cy = cy;
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        width = getMeasuredWidth();
//        height = getMeasuredHeight();
//        Log.d("barryyang", width + "->" + height);
//    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.clipRect(0, 0, dp2px(52), dp2px(17));
        canvas.drawBitmap(bitmap, null, new RectF(0, 0, dp2px(52), dp2px(17)), paint);
        canvas.save();
        path.reset();
        path.addRect(0, 0, dp2px(30), dp2px(27), Path.Direction.CW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            canvas.clipOutPath(path);
        } else {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
        canvas.drawRect(new Rect(0, 0, dp2px(52), dp2px(17)), paint);
        canvas.restore();
    }

    private int dp2px(float var1) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (var1 * density + 0.5f);
    }

}
