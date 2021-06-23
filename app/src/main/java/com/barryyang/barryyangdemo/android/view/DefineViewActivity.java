package com.barryyang.barryyangdemo.android.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/11/13 4:26 PM
 * @desc :
 */
public class DefineViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_view);
//        SportsView sportsView = findViewById(R.id.sportsview);
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(sportsView,"progress",0,65);
//        objectAnimator.setDuration(1000);
//        objectAnimator.start();
//        View viewById = findViewById(R.id.parent);
//        QQAnimation qqAnimation = new QQAnimation();
//        qqAnimation.setDuration(1800);
//        qqAnimation.setRepeatCount(2);
//        viewById.startAnimation(qqAnimation);
//        bezier();
        ScaleGestureDemoView scaleGestureDemoView = findViewById(R.id.action_image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.demo1);
        scaleGestureDemoView.setImageBitmap(bitmap);
    }

    private void bezier() {
//        final ImageView imageView = findViewById(R.id.iv_image);
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        final int heightPixels = displayMetrics.heightPixels;
//        imageView.post(new Runnable() {
//            @Override
//            public void run() {
//                int left = imageView.getLeft();
//                int top = imageView.getTop();
//                int height = imageView.getHeight();
//                int i = heightPixels - getStatusBarHeight(DefineViewActivity.this) - height;
//                PointF startPoint = new PointF(left, top);
//                PointF endPoint = new PointF(left, i);
//                PointF pointF1 = new PointF(0, i / 1.0f / 2);
//                TypeEvaluator<PointF> typeEvaluator = new BezierEvaluator(pointF1);
//                ValueAnimator valueAnimator = ValueAnimator.ofObject(typeEvaluator, startPoint, endPoint);
//                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        PointF pointF = (PointF) animation.getAnimatedValue();
//                        imageView.setX(pointF.x);
//                        imageView.setY(pointF.y);
//                    }
//                });
//                valueAnimator.setDuration(2000);
//                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//                valueAnimator.start();
//            }
//        });
    }

    private static class BezierEvaluator implements TypeEvaluator<PointF> {

        private final PointF point1;

        public BezierEvaluator(PointF point1){
            this.point1 = point1;
        }

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            PointF pointF = new PointF();
            pointF.x = startValue.x * (1 - fraction) * (1 - fraction)
                    + 2 * fraction * (1 - fraction) * point1.x
                    + fraction * fraction * endValue.x;
            pointF.y = startValue.y * (1 - fraction) * (1 - fraction)
                    + 2 * fraction * (1 - fraction) * point1.y
                    + fraction * fraction * endValue.y;
            return pointF;
        }
    }

    /**
     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
