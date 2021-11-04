package com.barryyang.barryyangdemo.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * @author : BarryYang
 * @date : 2021/11/4 11:54 上午
 * @desc :
 */
public class AnimImageView extends androidx.appcompat.widget.AppCompatImageView {

    private static final int IMAGE_HEIGHT = 200;

    public AnimImageView(Context context) {
        super(context);
    }


    public AnimImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public AnimImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置的高度最好是bitmap的高度，这样不好压缩变形。这里写死了
     * @param widthMeasureSpec 宽度
     * @param heightMeasureSpec 高度
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, dp2px(IMAGE_HEIGHT));
    }

    private int dp2px(float var1) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (var1 * density + 0.5f);
    }
}
