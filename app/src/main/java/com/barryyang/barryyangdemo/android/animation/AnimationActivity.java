package com.barryyang.barryyangdemo.android.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;
import com.barryyang.barryyangdemo.utils.ScreenUtils;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealFrameLayout;

/**
 * @author : BarryYang
 * @date : 2020/11/28 4:30 PM
 * @desc :
 */
public class AnimationActivity extends AppCompatActivity {

    private CircularRevealFrameLayout mAdVideoView;
    private ImageView mIvAd;
    private ImageView mIvCover;
    private ImageView mIvSmallAd;
    private View mSmallAdBg;
    private Group mGroupSmallAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mAdVideoView = findViewById(R.id.ad_video_view);
        mIvAd = findViewById(R.id.ad_image_view);
        mIvCover = findViewById(R.id.iv_cover);
        mIvSmallAd = findViewById(R.id.iv_small_ad);
        mSmallAdBg = findViewById(R.id.view_small_ad_bg);
        mGroupSmallAd = findViewById(R.id.group_small_ad);
    }

    /**
     * 视频广告展示
     *
     * @param view
     */
    public void showVideoAd(View view) {
        int[] location = new int[2];
        mAdVideoView.getLocationInWindow(location);
        int centerX = mAdVideoView.getWidth() / 2;
        int centerY = mAdVideoView.getHeight() / 2;
        LogUtil.printLogDebug(location[0] + "," + location[1]);
        LogUtil.printLogDebug(centerX + "," + centerY + "," + mAdVideoView.getWidth() + "," + mAdVideoView.getHeight());

        //求出要揭露 View 的对角线，来作为扩散圆的最大半径
        int hypotenuse = (int) Math.hypot(mAdVideoView.getWidth(), mAdVideoView.getHeight());
        Animator animator = CircularRevealCompat.createCircularReveal(mAdVideoView, centerX, centerY, 0, hypotenuse);
        animator.setDuration(1000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mAdVideoView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }

    /**
     * 视频动画隐藏
     *
     * @param view
     */
    public void hideVideoAd(View view) {

        int[] location = new int[2];
        mAdVideoView.getLocationInWindow(location);
        int centerX = mAdVideoView.getWidth() / 2;
        int centerY = mAdVideoView.getHeight() / 2;
        LogUtil.printLogDebug(location[0] + "," + location[1]);
        LogUtil.printLogDebug(centerX + "," + centerY + "," + mAdVideoView.getWidth() + "," + mAdVideoView.getHeight());

        //求出要揭露 View 的对角线，来作为扩散圆的最大半径
        int hypotenuse = (int) Math.hypot(mAdVideoView.getWidth(), mAdVideoView.getHeight());
        Animator animator = CircularRevealCompat.createCircularReveal(mAdVideoView, centerX, centerY, hypotenuse, 0);
        animator.setDuration(1000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mAdVideoView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();

    }

    /**
     * 图片广告展示
     *
     * @param view
     */
    public void showImageAnimation(View view) {

        mAdVideoView.setVisibility(View.INVISIBLE);

        //广告由0.5变成1.0
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIvAd, "ScaleX", 0.5F, 1.06F);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIvAd, "ScaleY", 0.5F, 1.06F);

        //广告变成不透明
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(mIvAd, "Alpha", 0.0f, 1.0f);

        //封面80ms变成透明
        ObjectAnimator animatorAlpha1 = ObjectAnimator.ofFloat(mIvCover, "Alpha", 1.0f, 0.0f);

        //设置各动画差值器
        animatorX.setInterpolator(new DecelerateInterpolator());
        animatorY.setInterpolator(new DecelerateInterpolator());
        animatorAlpha.setInterpolator(new LinearInterpolator());
        animatorAlpha1.setInterpolator(new LinearInterpolator());

        //设置各动画执行时间
        animatorX.setDuration(240);
        animatorY.setDuration(240);
        animatorAlpha.setDuration(240);
        animatorAlpha1.setDuration(80);

        //上面动画完成之后，则执行1.06变成1.0动画
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorX1 = ObjectAnimator.ofFloat(mIvAd, "ScaleX", 1.06F, 1.0F);
        ObjectAnimator animatorY1 = ObjectAnimator.ofFloat(mIvAd, "ScaleY", 1.06F, 1.0F);
        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.setInterpolator(new LinearInterpolator());
        animatorSet1.playTogether(animatorX1, animatorY1);
        animatorSet1.setDuration(80);

        animatorSet.play(animatorX)
                .with(animatorY)
                .with(animatorAlpha)
                .with(animatorAlpha1)
                .before(animatorSet1);

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mIvAd.setVisibility(View.VISIBLE);
                mIvCover.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }

    /**
     * 图片广告隐藏(手动点击关闭)
     *
     * @param view
     */
    public void hideImageAnimation(View view) {

        mAdVideoView.setVisibility(View.INVISIBLE);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIvAd, "ScaleX", 1.0f, 0.5f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mIvAd, "ScaleY", 1.0f, 0.5f);
        ObjectAnimator alphaAd = ObjectAnimator.ofFloat(mIvAd, "Alpha", 1.0f, 0.0f);
        ObjectAnimator alphaCover = ObjectAnimator.ofFloat(mIvCover, "Alpha", 0.0f, 1.0f);
        alphaCover.setStartDelay(3000);

        scaleX.setDuration(200);
        scaleY.setDuration(200);
        alphaAd.setDuration(200);
        alphaCover.setDuration(80);

        AnimatorSet animationSet = new AnimatorSet();
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.playTogether(scaleX, scaleY, alphaAd, alphaCover);

        animationSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mIvAd.setVisibility(View.VISIBLE);
                mIvAd.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        animationSet.start();
    }

    /**
     * 倒计时结束展示小广告
     *
     * @param view
     */
    public void showSmallImageAnimation(View view) {

        //先确定图片广告的宽高,在设置小广告的宽高，假设已经知道宽高，写死

        //图片的广告高度可能大于封面的高度，可能小于封面的高度

        //图片广告底部距离父view顶部的距离
        int adBottom = mIvAd.getBottom();
        int adTop = mIvAd.getTop();

        //小的图片广告底部距离父view顶部的距离
        int smallAdBottom = mIvSmallAd.getBottom();
        //小的图片广告顶部距离父view顶部的距离
        int smallAdTop = mIvSmallAd.getTop();
        //小的图片广告左边距离父view左边的距离
        int smallAdRLeft = mIvSmallAd.getLeft();
        int smallAdRight = mIvSmallAd.getRight();

        LogUtil.printLogDebug("图片广告距离顶部的距离：" + adBottom + ",小封面广告距离顶部的距离：" + smallAdBottom
                + ",小封面广告距离左边的距离：" + smallAdRLeft);

        //计算y轴最终缩小的大小
        int smallAdHeight = mIvSmallAd.getHeight();
        int adHeight = mIvAd.getHeight();
        float toY = smallAdHeight / 1.0f / adHeight;

        //计算x轴最终缩小的大小
        int smallAdWidth = mIvSmallAd.getWidth();
        int adWidth = mIvAd.getWidth();
        float toX = smallAdWidth / 1.0f / adWidth;

        LogUtil.printLogDebug("图片广告在Y轴上的缩小最终值：" + toY + ",图片广告在X轴上的缩小最终值：" + toX);

        //pivotX和pivotY是相对于该View左上角的坐标值而非相对于整个屏幕左上角的坐标值
        mIvAd.setPivotY(adHeight + smallAdBottom - adBottom);
        mIvAd.setPivotX(smallAdRLeft + smallAdWidth / 4.0f);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIvAd, "ScaleX", 1.0f, toX);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mIvAd, "ScaleY", 1.0f, toY);
        ObjectAnimator alphaCover = ObjectAnimator.ofFloat(mIvCover, "Alpha", 0.0f, 1.0f);

        alphaCover.setInterpolator(new LinearInterpolator());
        scaleX.setInterpolator(new DecelerateInterpolator());
        scaleY.setInterpolator(new DecelerateInterpolator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200);
        animatorSet.playTogether(scaleX, scaleY, alphaCover);

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mIvAd.setVisibility(View.INVISIBLE);
                mGroupSmallAd.setVisibility(View.VISIBLE);
                mSmallAdBg.setPivotX(0);
                mSmallAdBg.setPivotY(mSmallAdBg.getHeight());
                ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(mSmallAdBg, "ScaleX", 0.0f, 1.0f);
                scaleAnimator.setDuration(200);
                scaleAnimator.setInterpolator(new OvershootInterpolator());
                scaleAnimator.start();
                scaleAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        mSmallAdBg.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }
}
