package com.barryyang.barryyangdemo.android.view;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
//import com.dalong.marqueeview.MarqueeView;
import com.barryyang.barryyangdemo.utils.ScreenUtils;
import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;

import java.util.Arrays;
import java.util.List;

/**
 * @author : BarryYang
 * @date : 2020/11/13 4:26 PM
 * @desc :
 */
public class DefineViewActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_view);
        final MarqueeTextView marqueeView = findViewById(R.id.simpleMarqueeView);
        marqueeView.setText("ssssssssssssssssssssssssssssssssssssssssssssss");
        marqueeView.start();
//
//        final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。");
////SimpleMarqueeView<T>，SimpleMF<T>：泛型T指定其填充的数据类型，比如String，Spanned等
//        SimpleMF marqueeFactory = new SimpleMF(marqueeView.getContext());
//        marqueeFactory.setData(datas);
//        marqueeView.setMarqueeFactory(marqueeFactory);
//        marqueeView.startFlipping();

//    }
//    public void start(View v){
//        test.startScroll();
//    }
//    public void stop(View v){
//        test.stopScroll();
//    }
//    public void startFromHead(View v){
//        test.startFromHead();
//    }

//        findIds();
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
//        ScaleGestureDemoView scaleGestureDemoView = findViewById(R.id.action_image);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.demo1);
//        scaleGestureDemoView.setImageBitmap(bitmap);
    }

    private RelativeLayout mContentLayout;
    private RelativeLayout.LayoutParams mLayoutParams;


    private void findIds() {
//        mContentLayout = findViewById(R.id.ll_content);
//        findViewById(R.id.bt_scale_big).setOnClickListener(this);
//        findViewById(R.id.bt_scale_small).setOnClickListener(this);
//        mLayoutParams = (RelativeLayout.LayoutParams)
//                mContentLayout.getLayoutParams();
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bt_scale_big:
//                animScaleBig();
//                break;
//            case R.id.bt_scale_small:
//                animScaleSmall();
//                break;
//            default:
//                break;
//        }
    }

    private void animScaleBig() {
        ValueAnimator scaleBig = ValueAnimator.ofFloat(100, 200);
        scaleBig.setInterpolator(new LinearInterpolator());
        scaleBig.setDuration(1000);
        scaleBig.addUpdateListener(mListener);
        scaleBig.start();
    }

    private ValueAnimator.AnimatorUpdateListener mListener = new ValueAnimator
            .AnimatorUpdateListener() {

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            mLayoutParams.height = dp2px((float) animation.getAnimatedValue());
            mContentLayout.setLayoutParams(mLayoutParams);
        }
    };

    private void animScaleSmall() {
        ValueAnimator scaleBig = ValueAnimator.ofFloat(200, 100);
        scaleBig.setInterpolator(new LinearInterpolator());
        scaleBig.setDuration(1000);
        scaleBig.addUpdateListener(mListener);
        scaleBig.start();
    }

    private int dp2px(float var1) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (var1 * density + 0.5f);
    }

    //  private void bezier() {
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
//    }

//    private static class BezierEvaluator implements TypeEvaluator<PointF> {
//
//        private final PointF point1;
//
//        public BezierEvaluator(PointF point1){
//            this.point1 = point1;
//        }
//
//        @Override
//        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
//            PointF pointF = new PointF();
//            pointF.x = startValue.x * (1 - fraction) * (1 - fraction)
//                    + 2 * fraction * (1 - fraction) * point1.x
//                    + fraction * fraction * endValue.x;
//            pointF.y = startValue.y * (1 - fraction) * (1 - fraction)
//                    + 2 * fraction * (1 - fraction) * point1.y
//                    + fraction * fraction * endValue.y;
//            return pointF;
//        }
//    }
//
//    /**
//     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
//     *
//     * @return 返回状态栏高度的像素值。
//     */
//    public static int getStatusBarHeight(Context context) {
//        int result = 0;
//        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
//        if (resourceId > 0) {
//            result = context.getResources().getDimensionPixelSize(resourceId);
//        }
//        return result;
//    }


}
