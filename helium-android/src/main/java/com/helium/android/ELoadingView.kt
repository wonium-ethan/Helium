package com.helium.android

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.annotation.ColorInt
import cn.maizz.kotlin.extension.android.content.dp2px

/**
 * @ClassName:
 * @Description: https://www.jianshu.com/p/4732d8ae61fe
 * @Author: Ethan
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2020/2/21 13:42
 * @UpdateUser: Ethan
 * @UpdateDate: 2020/2/21 13:42
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */
class ELoadingView : View {


    companion object {
        // 小圆圈总数
        private const val CIRCLE_COUNT: Int = 12
        private const val DEGREE_PER_CIRCLE: Int = 360/ CIRCLE_COUNT
    }

    private val mWholeCircleRadius = FloatArray(CIRCLE_COUNT)
    private val mWholeCircleColors = IntArray(CIRCLE_COUNT)
    private var mMaxCircleRadius: Float = 0.0f
    /**
     * 组件的大小
     */
    private var mSize: Int = 0
    private var mColor: Int = 0
    private var mPaint: Paint? =null
    private var mAnimator: ValueAnimator? = null
    private var mAnimatorValue = 0
    private var mDuration: Long = 0L

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {
        initAttrs(context, attributeSet)
        initPaint()
        initValue()
    }


    /**
     * 初始化属性
     */
    private fun initAttrs(context: Context, attr: AttributeSet?) {
        val ta:TypedArray = context.obtainStyledAttributes(attr, R.styleable.ELoadingView)
        mSize = ta.getDimension(R.styleable.ELoadingView_hlv_size, context.dp2px(dpValue = 90).toFloat()).toInt()
        setSize(mSize)

        mColor = ta.getColor(R.styleable.ELoadingView_hlv_color, Color.parseColor("#a9a9a9"))
        setColor(mColor)

        mDuration = ta.getInt(R.styleable.ELoadingView_hlv_duration, 2500).toLong()

        ta.recycle()

    }

    /**
     * 初始化Paint
     */
    private fun initPaint() {
        mPaint=Paint()
        mPaint?.isAntiAlias = true

        mPaint?.style = Paint.Style.FILL

        mPaint?.color = mColor
    }

    private fun initValue() {
        val minCircleRadius = mSize / 24
        for (i in 0 until CIRCLE_COUNT step 1) when (i) {
            7 -> {
                mWholeCircleRadius[i] = minCircleRadius * 1.25f
                mWholeCircleColors[i] = (255 * 0.7f).toInt()
            }
            8 -> {
                mWholeCircleRadius[i] = minCircleRadius * 1.5f
                mWholeCircleColors[i] = (255 * 0.8f).toInt()
            }
            9, 11 -> {
                mWholeCircleRadius[i] = minCircleRadius * 1.75f
                mWholeCircleColors[i] = (255 * 0.9f).toInt()
            }
            10 -> {
                mWholeCircleRadius[i] = minCircleRadius * 2f
                mWholeCircleColors[i] = 255
            }
            else -> {
                mWholeCircleRadius[i] = minCircleRadius.toFloat()
                mWholeCircleColors[i] = (255 * 0.5f).toInt()
            }
        }
        mMaxCircleRadius = minCircleRadius * 2.toFloat()

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(mSize, mSize)
    }

    override fun onDraw(canvas: Canvas?) {
        if (mSize > 0) {
            canvas?.rotate(DEGREE_PER_CIRCLE * mAnimatorValue.toFloat(), mSize / 2F, mSize / 2F)
            for (i in 0 until CIRCLE_COUNT step 1) {

                mPaint?.alpha = mWholeCircleColors[i]
                canvas?.drawCircle(mSize / 2F, mMaxCircleRadius, mWholeCircleRadius[i], mPaint!!)
                canvas?.rotate(DEGREE_PER_CIRCLE.toFloat(), mSize / 2F, mSize / 2F)
            }
        }
    }


    public fun setSize(size: Int) {
        mSize = size
        invalidate()
    }

    public fun setColor(@ColorInt color: Int) {
        mColor = color
        invalidate()
    }


    private val mUpdateListener = ValueAnimator.AnimatorUpdateListener { animation ->
        mAnimatorValue = animation?.animatedValue as Int
        invalidate()
    }


    public fun start() {
        if (mAnimator == null) {
            mAnimator = ValueAnimator.ofInt(0, CIRCLE_COUNT - 1) as ValueAnimator
            mAnimator?.addUpdateListener(mUpdateListener)
            mAnimator?.duration = mDuration
            mAnimator?.repeatMode = ValueAnimator.RESTART
            mAnimator?.repeatCount = ValueAnimator.INFINITE
            mAnimator?.interpolator = LinearInterpolator()
            mAnimator?.start()
        } else if (mAnimator?.isStarted?.not() == true) {
            mAnimator?.start()
        }
    }

    public fun stop() {
        if (mAnimator != null) {
            mAnimator?.removeUpdateListener(mUpdateListener)
            mAnimator?.removeAllUpdateListeners()
            mAnimator?.cancel()
            mAnimator = null
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stop()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        if (visibility == VISIBLE) start() else stop()
    }


}