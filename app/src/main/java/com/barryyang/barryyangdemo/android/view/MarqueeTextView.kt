package com.barryyang.barryyangdemo.android.view

import android.content.Context
import android.util.AttributeSet
import kotlin.jvm.JvmOverloads
import android.widget.FrameLayout
import com.barryyang.barryyangdemo.utils.ScreenUtils
import android.widget.TextView
import android.widget.HorizontalScrollView
import android.view.LayoutInflater
import com.barryyang.barryyangdemo.R

/**
 * @author : BarryYang
 * @date : 2021/11/22 4:32 下午
 * @desc :
 */
class MarqueeTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr), Runnable {

    /**
     * 每隔多少毫秒刷新一次UI
     */
    private val mRefreshGap = 4

    /**
     * 每次滚动的距离
     */
    private val mEveryScrollDistance = 1

    /**
     * 滚动文本的宽度
     */
    private var mTextWidth = 0

    /**
     * 最大宽度
     */
    private val maxWidth = ScreenUtils.dip2px(getContext(), 134f)

    /**
     * 当前滚动的距离
     */
    private var mCurrentScrollDistance = 0

    private lateinit var mTvMarquee: TextView
    private lateinit var horizontalScrollView: HorizontalScrollView

    private fun initView() {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_marquee_view, this)
        mTvMarquee = view.findViewById(R.id.tv_marquee)
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView)
    }

    override fun run() {
        mTvMarquee.scrollTo(mCurrentScrollDistance, 0)
        mCurrentScrollDistance += mEveryScrollDistance
        if (mCurrentScrollDistance >= mTextWidth) {
            mCurrentScrollDistance = if (mTextWidth > maxWidth) {
                -maxWidth
            } else {
                -mTextWidth
            }
        }
        postDelayed(this, mRefreshGap.toLong())
    }

    fun stop() {
        removeCallbacks(this)
    }

    fun setText(text: String?) {
        mTvMarquee.text = text
        mTvMarquee.post {
            mTextWidth = mTvMarquee.width
            if (mTextWidth >= maxWidth) {
                val layoutParams = horizontalScrollView.layoutParams
                layoutParams.width = maxWidth
                horizontalScrollView.layoutParams = layoutParams
                mCurrentScrollDistance = -maxWidth
                mTvMarquee.scrollTo(mCurrentScrollDistance, 0)
                postDelayed(this@MarqueeTextView, mRefreshGap.toLong())
            } else {
                mCurrentScrollDistance = -mTextWidth
            }
        }
    }

    init {
        initView()
    }
}