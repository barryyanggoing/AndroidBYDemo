package com.barryyang.barryyangdemo.android.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author : BarryYang
 * @date : 2021/6/23 9:04 下午
 * @desc :
 */
public class ScaleGestureDemoView extends View {

    /**
     * 在默认尺寸基础上，允许放大的最大比例
     */
    private final float THRESHOLD_VALUE_MAX_SCALE = 2.0f;
    /**
     * 在默认尺寸基础上，允许缩小的最大比例
     */
    private final float THRESHOLD_VALUE_MIN_SCALE = 0.5f;

    /**
     * 是否触发了长按
     */
    private boolean isLongPress;
    private boolean isAlwaysInTapRegion;
    /**
     * 是否多指触控时，某根手指离开屏幕
     */
    private boolean isPointerUp;
    /**
     * 是否正在进行手势操作
     */
    private boolean isTouching;
    /**
     * 是否是双击缩放
     */
    private boolean isDoubleScale;

    private int mTouchSlopSquare;

    /**
     * 回弹阈值，即手拖拽图片离开屏幕边界的最大距离
     */
    private int mSpringBackValue;

    /**
     * 相对屏幕宽高比的较短边贴着屏幕时的缩放比例，即此时图片全屏展示，最短边贴着屏幕，最长边超出屏幕，为默认尺寸
     */
    private float mDefaultScale;
    /**
     * 允许放大到最大时的缩放大小
     */
    private float mBigScale;
    /**
     * 允许缩小到最小时的缩放大小
     */
    private float mSmallScale;
    /**
     * 当前缩放大小
     */
    private float currentScale;

    /**
     * 启动动画时的启示缩放比例
     */
    private float mAnimatorStartScale;
    /**
     * 启动动画时的目标缩放比例
     */
    private float mAnimatorTargetScale;
    /**
     * 为方便计算Offset，临时存储上一次的缩放当前缩放比例
     */
    private float mAnimatorTempScale;

    /**
     * 双指缩放时的中心X坐标
     */
    private float mScaleFocusX;
    /**
     * 双指缩放时的中心Y坐标
     */
    private float mScaleFocusY;

    /**
     * 原始图片，居中显示时的左边距
     */
    private float mOriginalOffsetX;
    /**
     * 原始图片，居中显示时的上边距
     */
    private float mOriginalOffsetY;

    private float offsetX;
    private float offsetY;
    private float mSpringBackOffsetX;
    private float mSpringBackOffsetY;

    /**
     * 触摸的X坐标值
     */
    private float mDownStartX;
    /**
     * 触摸的Y坐标值
     */
    private float mDownStartY;

    private float mDownFocusX;
    private float mDownFocusY;

    private Paint mPaint;
    private Bitmap mPictureBitmap;

    /**
     * 当前保留使用GestureDetectorCompat控制滚动，后面如果产品同意通过速度来区分翻页和拖拽，则使用该类会比较方便
     */
    private GestureDetectorCompat mDetector;
    private ObjectAnimator mScaleAnimator;
    private ObjectAnimator mTranslationXAnimator;
    private ObjectAnimator mTranslationYAnimator;
    private OverScroller mScroller;

    private MyRunnable mMyRunnable = new MyRunnable();
    private ScaleGestureDetector mScaleGestureDetector;

    private Disposable mLongPressDisposable;
    private OnTouchEventListener mTouchEventListener;

    public ScaleGestureDemoView(Context context) {
        super(context);
        init(context);
    }

    public ScaleGestureDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setFilterBitmap(true);
        mScroller = new OverScroller(context);
        mDetector = new GestureDetectorCompat(context, new MyGestureListener());
        mScaleGestureDetector = new ScaleGestureDetector(context, new MyScaleGestureListener());
        mDetector.setIsLongpressEnabled(false);

        ViewConfiguration configuration = ViewConfiguration.get(context);
        int touchSlop = configuration.getScaledTouchSlop();
        mTouchSlopSquare = touchSlop * touchSlop;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mSpringBackValue = h >> 1;
        if (mPictureBitmap != null && !mPictureBitmap.isRecycled()) {
            initScaleAndOffset(w, h);
        }
    }

    /**
     * 初始化缩放参数和偏移参数
     *
     * @param pWidth  控件宽度
     * @param pHeight 控件高度
     */
    private void initScaleAndOffset(int pWidth, int pHeight) {
        mOriginalOffsetX = (pWidth - mPictureBitmap.getWidth()) >> 1;
        mOriginalOffsetY = (pHeight - mPictureBitmap.getHeight()) >> 1;

        if (mPictureBitmap.getWidth() > 0 && mPictureBitmap.getHeight() > 0 && pHeight > 0) {
            //第一次加载，默认采用相对屏幕宽高比的较短边贴着屏幕时的缩放比例，即此时图片全屏展示，最短边贴着屏幕，最长边超出屏幕
            if (mPictureBitmap.getWidth() / (float) mPictureBitmap.getHeight() > pWidth / (float) pHeight) {
                //图片相对于屏幕更矮扁
                mDefaultScale = pHeight / (float) mPictureBitmap.getHeight();
            } else {
                mDefaultScale = pWidth / (float) mPictureBitmap.getWidth();
            }
            currentScale = mDefaultScale;
            mBigScale = mDefaultScale * THRESHOLD_VALUE_MAX_SCALE;
            mSmallScale = mDefaultScale * THRESHOLD_VALUE_MIN_SCALE;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPictureBitmap != null && !mPictureBitmap.isRecycled()) {
            if (!isDoubleScale && mAnimatorTargetScale > mDefaultScale) {
                //仅对放大过大，往回缩时采取offset计算
                float scaleDv = Math.abs(mAnimatorTargetScale - mAnimatorStartScale);
                if (scaleDv > 0) {
                    offsetX += (mScaleFocusX - getWidth() / 2f) * (1 - currentScale / mAnimatorTempScale);
                    offsetY += (mScaleFocusY - getHeight() / 2f) * (1 - currentScale / mAnimatorTempScale);
                    mAnimatorTempScale = currentScale;
                    fitOffset(currentScale);
                }
            }
            canvas.translate(offsetX, offsetY);

            canvas.scale(currentScale, currentScale, getWidth() >> 1, getHeight() >> 1);
            canvas.drawBitmap(mPictureBitmap, mOriginalOffsetX, mOriginalOffsetY, mPaint);
        }
    }

    /**
     * 设置绘本图片
     * 当前项目中，设置的绘本图片，宽高和屏幕相同
     *
     * @param pBitmap 绘本图片
     */
    public void setImageBitmap(Bitmap pBitmap) {
        this.mPictureBitmap = pBitmap;
        if (mPictureBitmap != null && !mPictureBitmap.isRecycled()) {
            initScaleAndOffset(getWidth(), getHeight());
            invalidate();
        }
    }

    public void setOnTouchEventListener(OnTouchEventListener pListener) {
        this.mTouchEventListener = pListener;
    }

    /**
     * 是否可以自动翻转下一页
     * 当前业务：在未进行放大，并且当前未进行手势操作时，才允许自动翻页
     *
     * @return true 允许自动翻页
     */
    public boolean isEnableAutoToNext() {
        return !isTouching && equestFloat(currentScale, mDefaultScale);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = mScaleGestureDetector.onTouchEvent(event);
        if (!mScaleGestureDetector.isInProgress()) {
            //缩放过程中，不进行触摸监听
            disposeTouchEvent(event);
            result = mDetector.onTouchEvent(event);
        }
        return result;
    }

    /**
     * 处理触摸事件，判断是否派遣给父控件处理
     *
     * @param event
     */
    private void disposeTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        boolean pointerUp = (action & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_UP;
        int skipIndex = pointerUp ? event.getActionIndex() : -1;

        // Determine focal point
        float sumX = 0, sumY = 0;
        int count = event.getPointerCount();
        for (int i = 0; i < count; i++) {
            if (skipIndex == i) {
                continue;
            }
            sumX += event.getX(i);
            sumY += event.getY(i);
        }
        int div = pointerUp ? count - 1 : count;
        float focusX = sumX / div;
        float focusY = sumY / div;

        switch (action) {
            case MotionEvent.ACTION_POINTER_DOWN:
                mDownFocusX = focusX;
                mDownFocusY = focusY;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                mDownFocusX = focusX;
                mDownFocusY = focusY;
                isPointerUp = true;
                if (event.getPointerCount() < 3) {
                    //说明当前屏幕最多只有一根手指触摸
                    scaleSpringBack();
                }
                break;
            case MotionEvent.ACTION_DOWN:
                isTouching = true;

                mDownFocusX = focusX;
                mDownFocusY = focusY;

                mDownStartX = event.getRawX();
                mDownStartY = event.getRawY();

                isPointerUp = false;
                isLongPress = false;
                isAlwaysInTapRegion = true;

                mLongPressDisposable = Observable.timer(200, TimeUnit.MILLISECONDS).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        isLongPress = true;
                        isAlwaysInTapRegion = false;
                    }
                });
                break;
            case MotionEvent.ACTION_MOVE:
                if (isAlwaysInTapRegion) {
                    int deltaX = (int) (focusX - mDownFocusX);
                    int deltaY = (int) (focusY - mDownFocusY);
                    int distance = (deltaX * deltaX) + (deltaY * deltaY);
                    if (distance > mTouchSlopSquare) {
                        isAlwaysInTapRegion = false;
                        if (mLongPressDisposable != null && !mLongPressDisposable.isDisposed()) {
                            mLongPressDisposable.dispose();
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                isTouching = false;

                if (mLongPressDisposable != null && !mLongPressDisposable.isDisposed()) {
                    mLongPressDisposable.dispose();
                }
                if (currentScale > mDefaultScale || isLongPress) {
                    amendmentOffset();
                } else {
                    if (!isPointerUp && mTouchEventListener != null) {
                        //没有触发长按，并且不是刚刚双指缩放后的手指抬起，则将触摸事件传递回父控件
                        mTouchEventListener.onTouchEvent(mDownStartX, mDownStartY, event.getRawX(), event.getRawY());
                    }
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                isLongPress = false;
                isAlwaysInTapRegion = false;
                if (mLongPressDisposable != null && !mLongPressDisposable.isDisposed()) {
                    mLongPressDisposable.dispose();
                }
                break;
            default:
                break;
        }
    }

    private ObjectAnimator getScaleAnimator(float pTargetScale) {
        if (mScaleAnimator == null) {
            mScaleAnimator = ObjectAnimator.ofFloat(this, "currentScale", 0);
            mScaleAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    amendmentOffset();
                    mAnimatorStartScale = 0.0f;
                    mAnimatorTargetScale = 0.0f;
                    mAnimatorTempScale = 0.0f;
                    mScaleFocusX = 0.0f;
                    mScaleFocusY = 0.0f;
                }
            });
        }
        mScaleAnimator.setFloatValues(currentScale, pTargetScale);
        return mScaleAnimator;
    }

    private ObjectAnimator getTranslationXAnimator() {
        if (mTranslationXAnimator == null) {
            mTranslationXAnimator = ObjectAnimator.ofFloat(this, "offsetX", 0);
        }
        mTranslationXAnimator.setFloatValues(offsetX, 0.0f);
        return mTranslationXAnimator;
    }

    private ObjectAnimator getTranslationYAnimator() {
        if (mTranslationYAnimator == null) {
            mTranslationYAnimator = ObjectAnimator.ofFloat(this, "offsetY", 0);
        }
        mTranslationYAnimator.setFloatValues(offsetY, 0.0f);
        return mTranslationYAnimator;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }

    public float getCurrentScale() {
        return currentScale;
    }

    public void setCurrentScale(float currentScale) {
        this.currentScale = currentScale;
        invalidate();
    }

    /**
     * 修复目标缩放比例的offset
     *
     * @param pTargetScale 目标缩放比例
     */
    private void fitOffset(float pTargetScale) {
        offsetX = Math.max(offsetX, -(mPictureBitmap.getWidth() * pTargetScale - getWidth()) / 2.0f);
        offsetX = Math.min(offsetX, (mPictureBitmap.getWidth() * pTargetScale - getWidth()) / 2.0f);
        offsetY = Math.max(offsetY, -(mPictureBitmap.getHeight() * pTargetScale - getHeight()) / 2.0f);
        offsetY = Math.min(offsetY, (mPictureBitmap.getHeight() * pTargetScale - getHeight()) / 2.0f);
    }

    /**
     * 计算当前缩放比例下，offsetX的边界值
     *
     * @param pOffsetX 距离屏幕左边的间距
     * @return 获取当前缩放比例下的左边距
     */
    private float fitOffsetX(float pOffsetX) {
        if (mPictureBitmap != null) {
            pOffsetX = Math.max(pOffsetX, -(mPictureBitmap.getWidth() * currentScale - getWidth()) / 2.0f);
            return Math.min(pOffsetX, (mPictureBitmap.getWidth() * currentScale - getWidth()) / 2.0f);
        }
        return pOffsetX;
    }

    /**
     * 计算当前缩放比例下，offsetY的边界值
     *
     * @param pOffsetY 距离屏幕上边的间距
     * @return 获取当前缩放比例下的上边距
     */
    private float fitOffsetY(float pOffsetY) {
        if (mPictureBitmap != null) {
            pOffsetY = Math.max(pOffsetY, -(mPictureBitmap.getHeight() * currentScale - getHeight()) / 2.0f);
            return Math.min(pOffsetY, (mPictureBitmap.getHeight() * currentScale - getHeight()) / 2.0f);
        }
        return pOffsetY;
    }

    private class MyGestureListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            isDoubleScale = false;
            boolean isAllowCanScroll = currentScale > mDefaultScale || isLongPress;

            if (isAllowCanScroll && mPictureBitmap != null && !mPictureBitmap.isRecycled()) {
                if (Math.abs(mSpringBackOffsetX) > 0) {
                    boolean isXorX = (offsetX > 0 && distanceX < 0) || (offsetX < 0 && distanceX > 0);
                    if (isXorX) {
                        //在扩大边距
                        offsetX = offsetX - distanceX * (1 - Math.abs(mSpringBackOffsetX) / mSpringBackValue);
                    } else {
                        //这里其实需要有个比较好的计算方法，计算合理offset值的。。。
                        offsetX -= distanceX;
                    }
                } else {
                    offsetX -= distanceX;
                }

                if (Math.abs(mSpringBackOffsetY) > 0) {
                    boolean isXorY = (offsetY > 0 && distanceY < 0) || (offsetY < 0 && distanceY > 0);
                    if (isXorY) {
                        offsetY = offsetY - distanceY * (1 - Math.abs(mSpringBackOffsetY) / mSpringBackValue);
                    } else {
                        offsetY -= distanceY;
                    }
                } else {
                    offsetY -= distanceY;
                }
                mSpringBackOffsetX = offsetX - fitOffsetX(offsetX);
                mSpringBackOffsetY = offsetY - fitOffsetY(offsetY);
                invalidate();
            }
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (mTouchEventListener != null) {
                mTouchEventListener.onSingleTapUp(e);
            }
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            isDoubleScale = true;

            mScaleFocusX = getWidth() >> 1;
            mScaleFocusY = getHeight() >> 1;

            mAnimatorTempScale = currentScale;
            mAnimatorStartScale = currentScale;
            if (currentScale > mDefaultScale) {
                //当前缩放大小，大于默认缩放状态，则缩小
                getScaleAnimator(mDefaultScale).setDuration(500).start();
                getTranslationXAnimator().setDuration(500).start();
                getTranslationYAnimator().setDuration(500).start();
                mAnimatorTargetScale = mDefaultScale;
            } else {
                getScaleAnimator(mBigScale).setDuration(500).start();
                mAnimatorTargetScale = mBigScale;
            }
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return false;
        }
    }

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            if (mScroller.computeScrollOffset() && !isDoubleScale) {
                offsetX = mScroller.getCurrX();
                offsetY = mScroller.getCurrY();
                invalidate();
                ViewCompat.postOnAnimation(ScaleGestureDemoView.this, this);
            }
        }
    }

    private class MyScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {

        float initialScale;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            isLongPress = false;
            mScaleFocusX = detector.getFocusX();
            mScaleFocusY = detector.getFocusY();
            float scale = initialScale * detector.getScaleFactor();
            if (scale > mSmallScale) {
                //仅需要对放大超过mSmallScale时才修改offset，其余情况，offset值不需要更改
                offsetX += (mScaleFocusX - getWidth() / 2f) * (1 - scale / currentScale);
                offsetY += (mScaleFocusY - getHeight() / 2f) * (1 - scale / currentScale);
            }
            currentScale = scale;
            invalidate();
            return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            initialScale = currentScale;
            isDoubleScale = false;
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            isLongPress = false;
        }
    }

    /**
     * 手动缩放放手后，如果超过最大或最小限制，则动画回弹回去
     */
    private void scaleSpringBack() {
        if (currentScale < mDefaultScale) {
            //双指缩小，超过smallScale尺寸，松手后动画恢复smallScale尺寸
            getScaleAnimator(mDefaultScale).start();
            if (!equestFloat(offsetX, 0.0f)) {
                getTranslationXAnimator().start();
            }
            if (!equestFloat(offsetY, 0.0f)) {
                getTranslationYAnimator().start();
            }
            mAnimatorTempScale = currentScale;
            mAnimatorStartScale = currentScale;
            mAnimatorTargetScale = mDefaultScale;
        } else if (currentScale > mBigScale) {
            //双指放大，超过bigScale尺寸，松手后动画恢复bigScale尺寸
            getScaleAnimator(mBigScale).start();
            mAnimatorTempScale = currentScale;
            mAnimatorStartScale = currentScale;
            mAnimatorTargetScale = mBigScale;
        } else {
            amendmentOffset();
        }
    }

    /**
     * 比较两个float值是否相等
     *
     * @param pFloat1
     * @param pFloat2
     * @return true 相等
     */
    public boolean equestFloat(float pFloat1, float pFloat2) {
        return Math.abs(pFloat1 - pFloat2) < 1e-6f;
    }

    /**
     * 修正offset，用于缩放或拖拽后，如果图片被与屏幕不贴边，则滚动回去贴边
     */
    private void amendmentOffset() {
        float springBackOffsetX = offsetX - fitOffsetX(offsetX);
        float springBackOffsetY = offsetY - fitOffsetY(offsetY);
        if (Math.abs(springBackOffsetX) > 0 || Math.abs(springBackOffsetY) > 0) {
            mScroller.startScroll((int) offsetX, (int) offsetY, (int) (-springBackOffsetX), (int) (-springBackOffsetY), 200);
            ViewCompat.postOnAnimation(this, mMyRunnable);
        }
    }

    public interface OnTouchEventListener {

        /**
         * 触摸事件回调，用于父控件判断是否进行翻页
         *
         * @param pDownRawX down事件rawX
         * @param pDownRawY down事件rawY
         * @param pUpRawX   up事件rawX
         * @param pUpRawY   up事件rawY
         * @return
         */
        boolean onTouchEvent(float pDownRawX, float pDownRawY, float pUpRawX, float pUpRawY);

        boolean onSingleTapUp(MotionEvent e);
    }
}
