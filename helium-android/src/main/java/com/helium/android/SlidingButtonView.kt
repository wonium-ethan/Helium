package com.helium.android

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.TextView

/**
 * Created by MJJ on 2015/7/25.
 */
class SlidingButtonView  : HorizontalScrollView {
    private var labelDelete: TextView? = null
    private var mScrollWidth = 0
    private var mSlidingButtonListener: SlidingButtonListener? = null
    private var isOpen = false
    private var once = false
    constructor(context: Context): this(context,null)

    constructor(context: Context, attributeSet: AttributeSet?): this(context, attributeSet,0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)


    init {
        this.overScrollMode = View.OVER_SCROLL_NEVER

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if(!once) {
            labelDelete = findViewById(R.id.labelDelete)
            once = true
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if(changed) {
            scrollTo(0, 0)
            mScrollWidth = labelDelete!!.width
            Log.i("asd", "mScrollWidth:$mScrollWidth")
        }
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        when(ev.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> mSlidingButtonListener!!.onDownOrMove(this)
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                changeScrollx()
                return true
            }

        }
        return super.onTouchEvent(ev)
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        labelDelete!!.translationX = l - mScrollWidth.toFloat()
    }

    fun changeScrollx() {
        if(scrollX >= mScrollWidth / 2) {
            smoothScrollTo(mScrollWidth, 0)
            isOpen = true
            mSlidingButtonListener!!.onMenuIsOpen(this)
        } else {
            smoothScrollTo(0, 0)
            isOpen = false
        }
    }

    fun openMenu() {
        if(isOpen) {
            return
        }
        smoothScrollTo(mScrollWidth, 0)
        isOpen = true
        mSlidingButtonListener!!.onMenuIsOpen(this)
    }

    fun closeMenu() {
        if(!isOpen) {
            return
        }
        smoothScrollTo(0, 0)
        isOpen = false
    }

    fun setSlidingButtonListener(listener: SlidingButtonListener?) {
        mSlidingButtonListener = listener
    }

    interface SlidingButtonListener {
        fun onMenuIsOpen(view: View?)
        fun onDownOrMove(slidingButtonView: SlidingButtonView?)
    }


}