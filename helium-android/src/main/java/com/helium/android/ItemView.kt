/*
 * Copyright  2018 Ethan
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.helium.android

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.ViewParent
import androidx.constraintlayout.widget.ConstraintLayout
import cn.maizz.kotlin.extension.android.content.px2sp
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * @ClassName: ItemView.class
 * @Description:
 * @Author: Ethan
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2018/12/22 12:34
 * @UpdateUser: update user
 * @UpdateDate: 2018/12/22 12:34
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */

/**
 * ItemView 点击事件的监听器
 */
interface OnItemClickListener {
    fun onItemClick(view: View)
}

/**
 * 子控件的点击事件回调监听器
 */

interface OnItemChildClickListener {
    fun onItemChildClick(parent: ViewParent, child: View)
}

class ItemView constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)


    /**
     * ItemView 的点击事件监听器对象
     */
    private lateinit var listener: OnItemClickListener

    /**
     * ItemView 的点击事件
     */
    private fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.listener = onItemClickListener
    }


    private lateinit var onItemChildClickListener: OnItemChildClickListener

    /**
     * 子控件注册点击事件
     */
    public fun setOnItemChildClickListener(onItemChildClickListener: OnItemChildClickListener) {
        this.onItemChildClickListener = onItemChildClickListener
    }


    /**
     * 左边的图标
     */
    private var leftIconResId: Int = 0
    private var leftIconBackground: Int = 0
    private var leftIconMarginLeft: Float = 0.0F
    private var leftIconMarginTop: Float = 0.0F
    private var leftIconMarginRight: Float = 0.0F
    private var leftIconMarginBottom: Float = 0.0F
    private var leftIconPaddingLeft: Float = 0.0F
    private var leftIconPaddingTop: Float = 0.0F
    private var leftIconPaddingRight: Float = 0.0F
    private var leftIconPaddingBottom: Float = 0.0F
    /**
     * 左边TextView的相关属性
     */
    private var leftText: String? = ""
    private var leftTextBackgroundResource: Int = 0
    private var leftTextMarginLeft: Float = 0.0F
    private var leftTextMarginTop: Float = 0.0F
    private var leftTextMarginRight: Float = 0.0F
    private var leftTextMarginBottom: Float = 0.0F
    private var leftTextPaddingLeft: Float = 0.0F
    private var leftTextPaddingTop: Float = 0.0F
    private var leftTextPaddingRight: Float = 0.0F
    private var leftTextPaddingBottom: Float = 0.0F
    private var leftTextSize: Float = 48.0F


    /**
     * 左边的次要TextView的相关属性
     */
    private var leftSubText: String? = ""
    private var leftSubTextBackgroundResource = 0
    private var leftSubTextMarginLeft: Float = 0.0F
    private var leftSubTextMarginTop: Float = 0.0F
    private var leftSubTextMarginRight: Float = 0.0F
    private var leftSubTextMarginBottom: Float = 0.0F
    private var leftSubTextPaddingLeft: Float = 0.0F
    private var leftSubTextPaddingTop: Float = 0.0F
    private var leftSubTextPaddingRight: Float = 0.0F
    private var leftSubTextPaddingBottom: Float = 0.0F
    private var leftSubTextSize = 42.0F
    /**
     * 右边的Icon
     */
    private var rightIconResId: Int = 0
    private var rightIconBackgroundResource = 0
    private var rightIconMarginLeft: Float = 0.0F
    private var rightIconMarginTop: Float = 0.0F
    private var rightIconMarginRight: Float = 0.0F
    private var rightIconMarginBottom: Float = 0.0F
    private var rightIconPaddingLeft: Float = 0.0F
    private var rightIconPaddingTop: Float = 0.0F
    private var rightIconPaddingRight: Float = 0.0F
    private var rightIconPaddingBottom: Float = 0.0F
    /**
     * 右边的主内容
     */
    private var rightText: String? = ""
    private var rightTextBackgroundResource: Int = 0
    private var rightTextMarginLeft: Float = 0.0F
    private var rightTextMarginTop: Float = 0.0F
    private var rightTextMarginRight: Float = 0.0F
    private var rightTextMarginBottom: Float = 0.0F
    private var rightTextPaddingLeft: Float = 0.0F
    private var rightTextPaddingTop: Float = 0.0F
    private var rightTextPaddingRight: Float = 0.0F
    private var rightTextPaddingBottom: Float = 0.0F
    private var rightTextSize: Float = 16.0F
    /**
     * 右边的次内容
     */
    private var rightSubText: String? = ""
    private var rightSubTextBackgroundResource: Int = 0
    private var rightSubTextMarginLeft: Float = 0.0F
    private var rightSubTextMarginTop: Float = 0.0F
    private var rightSubTextMarginRight: Float = 0.0F
    private var rightSubTextMarginBottom: Float = 0.0F
    private var rightSubTextPaddingLeft: Float = 0.0F
    private var rightSubTextPaddingTop: Float = 0.0F
    private var rightSubTextPaddingRight: Float = 0.0F
    private var rightSubTextPaddingBottom: Float = 0.0F
    private var rightSubTextSize: Float = 16.0F

    /**
     * 右边的未读消息
     */
    private var rightUnreadMessage: String? = ""
    private var rightUnreadMessageMarginLeft: Float = 0.0F
    private var rightUnreadMessageMarginTop: Float = 0.0F
    private var rightUnreadMessageMarginRight: Float = 0.0F
    private var rightUnreadMessageMarginBottom: Float = 0.0F
    private var rightUnreadMessagePaddingLeft: Float = 0.0F
    private var rightUnreadMessagePaddingTop: Float = 0.0F
    private var rightUnreadMessagePaddingRight: Float = 0.0F
    private var rightUnreadMessagePaddingBottom: Float = 0.0F
    private var rightUnreadMessageTextSize: Float = 28.0F
    private var rightUnreadMessageBackgroundResource = 0


    private var leftTextColor: Int
    private var leftSubTextColor: Int
    private var rightTextColor: Int
    private var rightSubTextColor: Int
    private var rightUnreadMessageTextColor: Int = 0

    private lateinit var leftIconParams: LayoutParams
    private lateinit var leftTextParams: LayoutParams
    private lateinit var leftSubTextParams: LayoutParams
    private lateinit var rightTextParams: LayoutParams
    private lateinit var rightSubTextParams: LayoutParams
    private lateinit var rightIconParams: LayoutParams
    private lateinit var rightUnreadMessageParams: LayoutParams
    private var bottomLineParams: LayoutParams

    private val defaultTextColor = Color.parseColor("#383A3E")

    init {
        View.inflate(context, R.layout.item_view, this)
        this.setOnClickListener { view -> listener.onItemClick(view) }
        itemLeftText.setOnClickListener { view ->
            onItemChildClickListener.onItemChildClick(
                this,
                view
            )
        }
        itemLeftSubText.setOnClickListener { view ->
            onItemChildClickListener.onItemChildClick(
                this,
                view
            )
        }
        itemLeftIcon.setOnClickListener { view ->
            onItemChildClickListener.onItemChildClick(
                this,
                view
            )
        }
        itemRightText.setOnClickListener { view ->
            onItemChildClickListener.onItemChildClick(
                this,
                view
            )
        }
        itemRightSubText.setOnClickListener { view ->
            onItemChildClickListener.onItemChildClick(
                this,
                view
            )
        }
        itemRightUnreadMessage.setOnClickListener { view ->
            onItemChildClickListener.onItemChildClick(
                this,
                view
            )
        }
        val typeArray: TypedArray = context!!.obtainStyledAttributes(attrs, R.styleable.ItemView)
        leftIconResId = typeArray.getResourceId(R.styleable.ItemView_leftIcon, 0)
        leftIconBackground = typeArray.getResourceId(R.styleable.ItemView_leftIconBackground, 0)
        leftIconMarginLeft = typeArray.getDimension(R.styleable.ItemView_leftIconMarginLeft, 0.0F)
        leftIconMarginTop = typeArray.getDimension(R.styleable.ItemView_leftIconMarginTop, 0.0F)
        leftIconMarginRight = typeArray.getDimension(R.styleable.ItemView_leftIconMarginRight, 0.0F)
        leftIconMarginBottom =
            typeArray.getDimension(R.styleable.ItemView_leftIconMarginBottom, 0.0F)
        leftIconPaddingLeft = typeArray.getDimension(R.styleable.ItemView_leftIconPaddingLeft, 0.0F)
        leftIconPaddingTop = typeArray.getDimension(R.styleable.ItemView_leftIconPaddingTop, 0.0F)
        leftIconPaddingRight =
            typeArray.getDimension(R.styleable.ItemView_leftIconPaddingRight, 0.0F)
        leftIconPaddingBottom =
            typeArray.getDimension(R.styleable.ItemView_leftIconPaddingBottom, 0.0F)

        // 左边主内容区
        leftText = typeArray.getString(R.styleable.ItemView_leftText)
        leftTextBackgroundResource =
            typeArray.getResourceId(R.styleable.ItemView_leftTextBackground, 0)
        leftTextMarginLeft = typeArray.getDimension(R.styleable.ItemView_leftTextMarginLeft, 0.0F)
        leftTextMarginTop = typeArray.getDimension(R.styleable.ItemView_leftTextMarginTop, 0.0F)
        leftTextMarginRight = typeArray.getDimension(R.styleable.ItemView_leftTextMarginRight, 0.0F)
        leftTextMarginBottom =
            typeArray.getDimension(R.styleable.ItemView_leftTextMarginBottom, 0.0F)
        leftTextPaddingLeft = typeArray.getDimension(R.styleable.ItemView_leftTextPaddingLeft, 0.0F)
        leftTextPaddingTop = typeArray.getDimension(R.styleable.ItemView_leftTextPaddingTop, 0.0F)
        leftTextPaddingRight =
            typeArray.getDimension(R.styleable.ItemView_leftTextPaddingRight, 0.0F)
        leftTextPaddingBottom =
            typeArray.getDimension(R.styleable.ItemView_leftTextPaddingBottom, 0.0F)
        leftTextSize = typeArray.getDimension(R.styleable.ItemView_leftTextSize, 48.0F)
        leftTextColor = typeArray.getColor(R.styleable.ItemView_leftTextColor, defaultTextColor)

        // 左边次内容区
        leftSubText = typeArray.getString(R.styleable.ItemView_leftSubText)
        leftSubTextSize = typeArray.getDimension(R.styleable.ItemView_leftSubTextSize, 42.0F)
        leftSubTextBackgroundResource =
            typeArray.getResourceId(R.styleable.ItemView_leftSubTextBackground, 0)
        leftSubTextMarginLeft =
            typeArray.getDimension(R.styleable.ItemView_leftSubTextMarginLeft, 0.0F)
        leftSubTextMarginTop =
            typeArray.getDimension(R.styleable.ItemView_leftSubTextMarginTop, 0.0F)
        leftSubTextMarginRight =
            typeArray.getDimension(R.styleable.ItemView_leftSubTextMarginRight, 0.0F)
        leftSubTextMarginBottom =
            typeArray.getDimension(R.styleable.ItemView_leftSubTextMarginBottom, 0.0F)
        leftSubTextPaddingLeft =
            typeArray.getDimension(R.styleable.ItemView_leftSubTextPaddingLeft, 0.0F)
        leftSubTextPaddingTop =
            typeArray.getDimension(R.styleable.ItemView_leftSubTextPaddingTop, 0.0F)
        leftSubTextPaddingRight =
            typeArray.getDimension(R.styleable.ItemView_leftSubTextPaddingRight, 0.0F)
        leftSubTextPaddingBottom =
            typeArray.getDimension(R.styleable.ItemView_leftSubTextPaddingBottom, 0.0F)
        leftSubTextColor =
            typeArray.getColor(R.styleable.ItemView_leftSubTextColor, defaultTextColor)
        val leftSubTextVisibility = typeArray.getInt(R.styleable.ItemView_leftSubTextVisibility, 2)
        setLeftSubTextVisibility(leftSubTextVisibility)
        // 右边图标
        rightIconResId = typeArray.getResourceId(R.styleable.ItemView_rightIcon, 0)
        rightIconBackgroundResource =
            typeArray.getResourceId(R.styleable.ItemView_rightIconBackground, 0)
        rightIconMarginLeft = typeArray.getDimension(R.styleable.ItemView_rightIconMarginLeft, 0.0F)
        rightIconMarginTop = typeArray.getDimension(R.styleable.ItemView_rightIconMarginTop, 0.0F)
        rightIconMarginRight =
            typeArray.getDimension(R.styleable.ItemView_rightIconMarginRight, 0.0F)
        rightIconMarginBottom =
            typeArray.getDimension(R.styleable.ItemView_rightIconMarginBottom, 0.0F)
        rightIconPaddingLeft =
            typeArray.getDimension(R.styleable.ItemView_rightIconPaddingLeft, 0.0F)
        rightIconPaddingTop = typeArray.getDimension(R.styleable.ItemView_rightIconPaddingTop, 0.0F)
        rightIconPaddingRight =
            typeArray.getDimension(R.styleable.ItemView_rightIconPaddingRight, 0.0F)
        rightIconPaddingBottom =
            typeArray.getDimension(R.styleable.ItemView_rightIconPaddingBottom, 0.0F)

        // 右边主内容区
        rightText = typeArray.getString(R.styleable.ItemView_rightText)
        rightTextBackgroundResource =
            typeArray.getResourceId(R.styleable.ItemView_rightTextBackground, 0)
        rightTextMarginLeft = typeArray.getDimension(R.styleable.ItemView_rightTextMarginLeft, 0.0F)
        rightTextMarginTop = typeArray.getDimension(R.styleable.ItemView_rightTextMarginTop, 0.0F)
        rightTextMarginRight =
            typeArray.getDimension(R.styleable.ItemView_rightTextMarginRight, 0.0F)
        rightTextMarginBottom =
            typeArray.getDimension(R.styleable.ItemView_rightTextMarginBottom, 0.0F)
        rightTextPaddingLeft =
            typeArray.getDimension(R.styleable.ItemView_rightTextPaddingLeft, 0.0F)
        rightTextPaddingTop = typeArray.getDimension(R.styleable.ItemView_rightTextPaddingTop, 0.0F)
        rightTextPaddingRight =
            typeArray.getDimension(R.styleable.ItemView_rightTextPaddingRight, 0.0F)
        rightTextPaddingBottom =
            typeArray.getDimension(R.styleable.ItemView_rightTextPaddingBottom, 0.0F)
        rightTextSize = typeArray.getDimension(R.styleable.ItemView_rightTextSize, 48.0F)
        rightTextColor = typeArray.getColor(R.styleable.ItemView_rightTextColor, defaultTextColor)
        // 右边次内容区
        rightSubText = typeArray.getString(R.styleable.ItemView_rightSubText)
        rightSubTextBackgroundResource =
            typeArray.getResourceId(R.styleable.ItemView_rightSubTextBackground, 0)
        rightSubTextMarginLeft =
            typeArray.getDimension(R.styleable.ItemView_rightSubTextMarginLeft, 0.0F)
        rightSubTextMarginTop =
            typeArray.getDimension(R.styleable.ItemView_rightSubTextMarginTop, 0.0F)
        rightSubTextMarginRight =
            typeArray.getDimension(R.styleable.ItemView_rightSubTextMarginRight, 0.0F)
        rightSubTextMarginBottom =
            typeArray.getDimension(R.styleable.ItemView_rightSubTextMarginBottom, 0.0F)
        rightSubTextPaddingLeft =
            typeArray.getDimension(R.styleable.ItemView_rightSubTextPaddingLeft, 0.0F)
        rightSubTextPaddingTop =
            typeArray.getDimension(R.styleable.ItemView_rightSubTextPaddingTop, 0.0F)
        rightSubTextPaddingRight =
            typeArray.getDimension(R.styleable.ItemView_rightSubTextPaddingRight, 0.0F)
        rightSubTextPaddingBottom =
            typeArray.getDimension(R.styleable.ItemView_rightSubTextPaddingBottom, 0.0F)
        rightSubTextSize = typeArray.getDimension(R.styleable.ItemView_rightSubTextSize, 42.0F)
        rightSubTextColor =
            typeArray.getColor(R.styleable.ItemView_rightSubTextColor, defaultTextColor)
        setRightSubTextVisible(typeArray.getInt(R.styleable.ItemView_rightSubTextVisible, 2))
        // 未读消息
        rightUnreadMessage = typeArray.getString(R.styleable.ItemView_rightUnreadMessage)
        rightUnreadMessageMarginLeft =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessageMarginLeft, 0.0F)
        rightUnreadMessageMarginTop =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessageMarginTop, 0.0F)
        rightUnreadMessageMarginRight =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessageMarginRight, 0.0F)
        rightUnreadMessageMarginBottom =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessageMarginBottom, 0.0F)
        rightUnreadMessagePaddingLeft =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessagePaddingLeft, 0.0F)
        rightUnreadMessagePaddingTop =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessagePaddingTop, 0.0F)
        rightUnreadMessagePaddingRight =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessagePaddingRight, 0.0F)
        rightUnreadMessagePaddingBottom =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessagePaddingBottom, 0.0F)
        rightUnreadMessageTextColor =
            typeArray.getColor(R.styleable.ItemView_rightUnreadMessageTextColor, defaultTextColor)
        rightUnreadMessageBackgroundResource =
            typeArray.getResourceId(R.styleable.ItemView_rightUnreadMessageTextBackground, 0)
        rightUnreadMessageTextSize =
            typeArray.getDimension(R.styleable.ItemView_rightUnreadMessageTextSize, 36.0F)


        bottomLineParams = itemBottomLine.layoutParams as LayoutParams
        setBottomLineMarginLeft(
            typeArray.getDimension(
                R.styleable.ItemView_bottomLineMarginLeft,
                0.0F
            )
        )
        setBottomLineMarginTop(
            typeArray.getDimension(
                R.styleable.ItemView_bottomLineMarginTop,
                0.0F
            )
        )
        setBottomLineMarginRight(
            typeArray.getDimension(
                R.styleable.ItemView_bottomLineMarginRight,
                0.0F
            )
        )
        setBottomLineMarginBottom(
            typeArray.getDimension(
                R.styleable.ItemView_bottomLineMarginBottom,
                0.0F
            )
        )
        val bottomLinePaddingLeft =
            typeArray.getDimension(R.styleable.ItemView_bottomLinePaddingLeft, 0.0F)
        val bottomLinePaddingTop =
            typeArray.getDimension(R.styleable.ItemView_bottomLinePaddingTop, 0.0F)
        val bottomLinePaddingRight =
            typeArray.getDimension(R.styleable.ItemView_bottomLinePaddingRight, 0.0F)
        val bottomLinePaddingBottom =
            typeArray.getDimension(R.styleable.ItemView_bottomLinePaddingBottom, 0.0F)
        setBottomLinePadding(
            bottomLinePaddingLeft,
            bottomLinePaddingTop,
            bottomLinePaddingRight,
            bottomLinePaddingBottom
        )
        setBottomLineBackground(
            typeArray.getResourceId(
                R.styleable.ItemView_bottomLineBackground,
                defaultTextColor
            )
        )
        setBottomLineVisibility(typeArray.getInt(R.styleable.ItemView_bottomLineVisible, 2))
        initView()
        typeArray.recycle()
    }

    /**
     * 初始化
     */
    private fun initView() {
        leftIconParams = itemLeftIcon.layoutParams as LayoutParams
        leftTextParams = itemLeftText.layoutParams as LayoutParams
        leftSubTextParams = itemLeftSubText.layoutParams as LayoutParams
        rightIconParams = itemRightIcon.layoutParams as LayoutParams
        rightTextParams = itemRightText.layoutParams as LayoutParams
        rightSubTextParams = itemRightSubText.layoutParams as LayoutParams
        rightUnreadMessageParams = itemRightUnreadMessage.layoutParams as LayoutParams


        // 初始化左边图标的相关属性
        setLeftIconImageResource(leftIconResId)
        setLeftIconBackgroundResource(leftIconBackground)
        setLeftIconMarginLeft(leftIconMarginLeft)
        setLeftIconMarginTop(leftIconMarginTop)
        setLeftIconMarginRight(leftIconMarginRight)
        setLeftIconMarginBottom(leftIconMarginBottom)
        setLeftIconPadding(
            leftIconPaddingLeft,
            leftIconPaddingTop,
            leftIconPaddingRight,
            leftIconPaddingBottom
        )

        // 初始化左边主文本控件的相关内容
        setLeftText(leftText)
        setLeftTextSize(leftTextSize)
        setLeftTextBackgroundResource(leftTextBackgroundResource)
        setLeftTextMarginLeft(leftTextMarginLeft)
        setLeftTextMarginTop(leftTextMarginTop)
        setLeftTextMarginRight(leftTextMarginRight)
        setLeftTextMarginBottom(leftTextMarginBottom)
        setLeftTextPadding(
            leftTextPaddingLeft,
            leftTextPaddingTop,
            leftTextPaddingRight,
            leftTextPaddingBottom
        )
        setLeftTextColor(leftTextColor)

        // 初始化左边次文本控件的相关内容
        setLeftSubText(leftSubText)
        setLeftSubTextSize(leftSubTextSize)
        setLeftSubTextBackgroundResource(leftSubTextBackgroundResource)
        setLeftSubTextMarginLeft(leftSubTextMarginLeft)
        setLeftSubTextMarginTop(leftSubTextMarginTop)
        setLeftSubTextMarginRight(leftSubTextMarginRight)
        setLeftSubTextMarginBottom(leftSubTextMarginBottom)
        setLeftSubTextPadding(
            leftSubTextPaddingLeft,
            leftSubTextPaddingTop,
            leftSubTextPaddingRight,
            leftSubTextPaddingBottom
        )
        setLeftSubTextColor(leftSubTextColor)


        setRightIconImageResource(rightIconResId)
        setRightIconBackgroundResource(rightIconBackgroundResource)
        setRightIconMarginLeft(rightIconMarginLeft)
        setRightIconMarginTop(rightIconMarginTop)
        setRightIconMarginRight(rightIconMarginRight)
        setRightIconMarginBottom(rightIconMarginBottom)
        setRightIconPadding(
            rightIconPaddingLeft,
            rightIconPaddingTop,
            rightIconPaddingRight,
            rightIconPaddingBottom
        )


        // 初始化左边主文本控件的相关内容
        setRightText(rightText)
        setRightTextBackgroundResource(rightTextBackgroundResource)
        setRightTextMarginLeft(rightTextMarginLeft)
        setRightTextMarginTop(rightTextMarginTop)
        setRightTextMarginRight(rightTextMarginRight)
        setRightTextMarginBottom(rightTextMarginBottom)
        setRightTextPadding(
            rightTextPaddingLeft,
            rightTextPaddingTop,
            rightTextPaddingRight,
            rightTextPaddingBottom
        )
        setRightTextSize(rightTextSize)
        setRightTextColor(rightTextColor)

        setRightSubText(rightSubText)
        setRightSubTextBackgroundResource(rightSubTextBackgroundResource)
        setRightSubTextMarginTop(rightSubTextMarginTop)
        setRightSubTextMarginLeft(rightSubTextMarginLeft)
        setRightSubTextMarginRight(rightSubTextMarginRight)
        setRightSubTextMarginBottom(rightSubTextMarginBottom)
        setRightSubTextPadding(
            rightSubTextPaddingLeft,
            rightSubTextPaddingTop,
            rightSubTextPaddingRight,
            rightSubTextPaddingBottom
        )
        setRightSubTextSize(rightSubTextSize)
        setRightSubTextColor(rightSubTextColor)

        setRightUnreadMessage(rightUnreadMessage)
        setRightUnreadMessageBackgroundResource(rightUnreadMessageBackgroundResource)
        setRightUnreadMessageMarginTop(rightUnreadMessageMarginTop)
        setRightUnreadMessageMarginLeft(rightUnreadMessageMarginLeft)
        setRightUnreadMessageMarginRight(rightUnreadMessageMarginRight)
        setRightUnreadMessageMarginBottom(rightUnreadMessageMarginBottom)
        setRightUnreadMessagePadding(
            rightUnreadMessagePaddingLeft,
            rightUnreadMessagePaddingTop,
            rightUnreadMessagePaddingRight,
            rightUnreadMessagePaddingBottom
        )
        setRightUnreadMessageTextSize(rightUnreadMessageTextSize)
        setRightUnreadMessageTextColor(rightUnreadMessageTextColor)


    }

    /***********************************设置左边的图标********************************************************************
     * @param resId 资源Id
     */

    public fun setLeftIconImageResource(resId: Int) {
        leftIconResId = resId
        this.itemLeftIcon.setImageResource(leftIconResId)
        itemLeftIcon.layoutParams = leftIconParams
    }


    public fun setLeftIconBackgroundResource(resId: Int) {
        leftIconBackground = resId
        itemLeftIcon.setBackgroundResource(leftIconBackground)
    }


    /**
     * 设置左边图标的左边距（外部）
     */
    public fun setLeftIconMarginLeft(leftMargin: Float) {
        leftIconMarginLeft = leftMargin
        leftIconParams.leftMargin = leftIconMarginLeft.toInt()
    }

    /**
     * 设置LeftIcon 的上边距 外部
     */
    public fun setLeftIconMarginTop(topMargin: Float) {
        leftIconMarginTop = topMargin
        leftIconParams.topMargin = leftIconMarginTop.toInt()
        itemLeftIcon.layoutParams = leftIconParams
    }

    /**
     * 设置LeftIcon 的右边距（外部）
     */
    public fun setLeftIconMarginRight(rightMargin: Float) {
        leftIconMarginRight = rightMargin
        leftIconParams.rightMargin = leftIconMarginRight.toInt()
        itemLeftIcon.layoutParams = leftIconParams
    }

    /**
     * 设置LeftIcon 的下边距（外部）
     */
    public fun setLeftIconMarginBottom(bottomMargin: Float) {
        leftIconMarginBottom = bottomMargin
        leftIconParams.bottomMargin = leftIconMarginBottom.toInt()
        itemLeftIcon.layoutParams = leftIconParams
    }

    /**
     * 设置左边Icon 的内边距
     */
    public fun setLeftIconPadding(left: Float, top: Float, right: Float, bottom: Float) {
        leftIconPaddingLeft = left
        leftIconPaddingTop = top
        leftIconPaddingRight = right
        leftIconPaddingBottom = bottom

        itemLeftIcon.setPadding(
            leftIconPaddingLeft.toInt(),
            leftIconPaddingTop.toInt(),
            leftIconPaddingRight.toInt(),
            leftIconPaddingBottom.toInt()
        )

    }

    /**
     * 设置LeftIcon 左边的填充像素
     */
    public fun setLeftIconPaddingLeft(left: Float) {
        setLeftIconPadding(left, 0.0F, 0.0F, 0.0F)
    }

    /**
     * 设置LeftIcon 上边的填充像素
     */
    public fun setLeftIconPaddingTop(top: Float) {
        setLeftIconPadding(0.0F, top, 0.0F, 0.0F)
    }

    /**
     * 设置LeftIcon 左边的填充像素
     */
    public fun setLeftIconPaddingRight(right: Float) {
        setLeftIconPadding(0.0F, 0.0F, right, 0.0F)
    }

    /**
     * 设置LeftIcon 的下边距（外部）
     */
    public fun setLeftIconPaddingBottom(bottom: Float) {
        setLeftIconPadding(0.0F, 0.0f, 0.0f, bottom)
    }


    /***************设置左边主文本控件的相关方法***************************************************************************
     *
     * 设置左边主文本控件的内容
     */
    public fun setLeftText(text: String?) {
        leftText = text
        itemLeftText.text = leftText
    }

    /**
     * @param size 缩放像素大小
     */
    public fun setLeftTextSize(size: Float) {
        setLeftTextSize(TypedValue.COMPLEX_UNIT_SP, context.px2sp(size).toFloat())
    }

    /**
     * 给定单位的字体大小
     */
    public fun setLeftTextSize(unit: Int, size: Float) {
        itemLeftText.setTextSize(unit, size)
    }

    /**
     * 缩放像素大小
     */
    public fun getLeftTextSize(): Float {
        return itemLeftText.textSize;
    }


    public fun setLeftTextBackgroundResource(resId: Int) {
        leftTextBackgroundResource = resId
        itemLeftText.setBackgroundResource(resId)
    }

    /**
     * 设置左边主文本的左边距（外部）
     */
    public fun setLeftTextMarginLeft(leftMargin: Float) {
        leftTextMarginLeft = leftMargin
        leftTextParams.leftMargin = leftTextMarginLeft.toInt()
        itemLeftText.layoutParams = leftTextParams
    }

    /**
     * 设置LeftText 的上边距 外部
     */
    public fun setLeftTextMarginTop(topMargin: Float) {
        leftTextMarginTop = topMargin
        leftTextParams.topMargin = leftTextMarginTop.toInt()
        itemLeftText.layoutParams = leftTextParams
    }

    /**
     * 设置LeftText 的右边距（外部）
     */
    public fun setLeftTextMarginRight(rightMargin: Float) {
        leftTextMarginRight = rightMargin
        leftTextParams.rightMargin = leftTextMarginRight.toInt()
        itemLeftText.layoutParams = leftTextParams
    }

    /**
     * 设置LeftText 的下边距（外部）
     */
    public fun setLeftTextMarginBottom(bottomMargin: Float) {
        leftTextMarginBottom = bottomMargin
        leftTextParams.bottomMargin = leftTextMarginBottom.toInt()
        itemLeftText.layoutParams = leftTextParams
    }

    /**
     * 设置LeftText 的内边距
     */
    public fun setLeftTextPadding(left: Float, top: Float, right: Float, bottom: Float) {
        leftTextPaddingLeft = left
        leftTextPaddingTop = top
        leftTextPaddingRight = right
        leftTextPaddingBottom = bottom
        itemLeftText.setPadding(
            leftTextPaddingLeft.toInt(),
            leftTextPaddingTop.toInt(),
            leftTextPaddingRight.toInt(),
            leftTextPaddingBottom.toInt()
        )
    }

    /**
     * 设置LeftText 左边的填充像素
     */
    public fun setLeftTextPaddingLeft(left: Float) {
        setLeftTextPadding(left, 0.0F, 0.0F, 0.0F)
    }

    /**
     * 设置LeftText 上边的填充像素
     */
    public fun setLeftTextPaddingTop(top: Float) {
        setLeftTextPadding(0.0F, top, 0.0F, 0.0F)
    }

    /**
     * 设置LeftText 左边的填充像素
     */
    public fun setLeftTextPaddingRight(right: Float) {
        setLeftTextPadding(0.0F, 0.0F, right, 0.0F)
    }

    /**
     * 设置LeftText 的下边距（外部）
     */
    public fun setLeftTextPaddingBottom(bottom: Float) {
        setLeftTextPadding(0.0F, 0.0f, 0.0f, bottom)
    }

    /**
     * ********************************设置左边次内容区********************************************************************
     * 设置左边次文本控件的内容
     */
    public fun setLeftSubText(text: String?) {
        leftSubText = text
        itemLeftSubText.text = leftSubText
    }


    /**
     * @param size 缩放像素大小
     */
    public fun setLeftSubTextSize(size: Float) {
        setLeftSubTextSize(TypedValue.COMPLEX_UNIT_SP, context.px2sp(size).toFloat())
    }

    /**
     * 给定单位的字体大小
     */
    public fun setLeftSubTextSize(unit: Int, size: Float) {
        leftSubTextSize = size
        itemLeftSubText.setTextSize(unit, leftSubTextSize)
    }

    /**
     * 缩放像素大小
     */
    public fun getLeftSubTextSize(): Float {
        return leftSubTextSize
    }


    public fun setLeftSubTextBackgroundResource(resId: Int) {
        leftSubTextBackgroundResource = resId
        itemLeftSubText.setBackgroundResource(leftSubTextBackgroundResource)
    }

    /**
     * 设置左边次文本的左边距（外部）
     */
    public fun setLeftSubTextMarginLeft(leftMargin: Float) {
        leftSubTextMarginLeft = leftMargin
        leftSubTextParams.leftMargin = leftSubTextMarginLeft.toInt()
        itemLeftSubText.layoutParams = leftSubTextParams
    }

    /**
     * 设置LeftSubText 的上边距 外部
     */
    public fun setLeftSubTextMarginTop(topMargin: Float) {
        leftSubTextMarginTop = topMargin
        leftSubTextParams.topMargin = leftSubTextMarginTop.toInt()
        itemLeftSubText.layoutParams = leftSubTextParams
    }

    /**
     * 设置LeftSubText 的右边距（外部）
     */
    public fun setLeftSubTextMarginRight(rightMargin: Float) {
        leftSubTextMarginRight = rightMargin
        leftSubTextParams.rightMargin = leftSubTextMarginRight.toInt()
        itemLeftSubText.layoutParams = leftSubTextParams
    }


    /**
     * 设置LeftSubText 的下边距（外部）
     * @param bottomMargin 距离父组件底部的距离
     */
    public fun setLeftSubTextMarginBottom(bottomMargin: Float) {
        leftSubTextMarginBottom = bottomMargin
        leftSubTextParams.bottomMargin = leftSubTextMarginBottom.toInt()
        itemLeftSubText.layoutParams = leftSubTextParams
    }

    /**
     * 设置LeftText 的内边距
     */
    public fun setLeftSubTextPadding(left: Float, top: Float, right: Float, bottom: Float) {
        leftSubTextPaddingLeft = left
        leftSubTextPaddingTop = top
        leftSubTextPaddingRight = right
        leftSubTextPaddingBottom = bottom
        itemLeftSubText.setPadding(
            leftSubTextPaddingLeft.toInt(),
            leftSubTextPaddingTop.toInt(),
            leftSubTextPaddingRight.toInt(),
            leftSubTextPaddingBottom.toInt()
        )
    }

    /**
     * 设置是否可见
     */
    public fun setLeftSubTextVisibility(visibility: Int) {
        itemLeftSubText.visibility = when (visibility) {
            0 -> View.VISIBLE
            1 -> View.INVISIBLE
            else -> View.GONE
        }
    }

    /**
     * 设置LeftText 左边的填充像素
     */
    public fun setLeftSubTextPaddingLeft(left: Float) {
        setLeftSubTextPadding(left, 0.0F, 0.0F, 0.0F)
    }

    /**
     * 设置LeftText 上边的填充像素
     */
    public fun setLeftSubTextPaddingTop(top: Float) {
        setLeftSubTextPadding(0.0F, top, 0.0F, 0.0F)
    }

    /**
     * 设置LeftText 左边的填充像素
     */
    public fun setLeftSubTextPaddingRight(right: Float) {
        setLeftSubTextPadding(0.0F, 0.0F, right, 0.0F)
    }

    /**
     * 设置LeftText 的下边距（外部）
     */
    public fun setLeftSubTextPaddingBottom(bottom: Float) {
        setLeftSubTextPadding(0.0F, 0.0f, 0.0f, bottom)
    }


    /*****************************************右边图标属性**************************************************************************
     *  RightIcon设置图片资源
     */
    public fun setRightIconImageResource(resId: Int) {
        rightIconResId = resId
        this.itemRightIcon.setImageResource(rightIconResId)
    }

    /**
     * 右边图标的背景
     * @param resId 背景资源Id
     */
    public fun setRightIconBackgroundResource(resId: Int) {
        rightIconBackgroundResource = resId
        itemRightIcon.setBackgroundResource(rightIconBackgroundResource)
    }

    /**
     * 设置RightIcon的左边距（外部）
     */
    public fun setRightIconMarginLeft(leftMargin: Float) {
        rightIconMarginLeft = leftMargin
        rightIconParams.leftMargin = rightIconMarginLeft.toInt()
        itemRightIcon.layoutParams = rightIconParams
    }

    /**
     * 设置RightIcon 的上边距 外部
     */
    public fun setRightIconMarginTop(topMargin: Float) {
        rightIconMarginTop = topMargin
        rightIconParams.topMargin = rightIconMarginTop.toInt()
        itemRightIcon.layoutParams = rightIconParams
    }

    /**
     * 设置RightIcon 的右边距（外部）
     */
    public fun setRightIconMarginRight(rightMargin: Float) {
        rightIconMarginRight = rightMargin
        rightIconParams.rightMargin = rightIconMarginRight.toInt()
        itemRightIcon.layoutParams = rightIconParams
    }

    /**
     * 设置RightIcon 的下边距（外部）
     */
    public fun setRightIconMarginBottom(bottomMargin: Float) {
        rightIconMarginBottom = bottomMargin
        rightIconParams.bottomMargin = rightIconMarginBottom.toInt()
        itemRightIcon.layoutParams = rightIconParams
    }

    /**
     * 设置RightIcon 的内边距
     */
    public fun setRightIconPadding(left: Float, top: Float, right: Float, bottom: Float) {
        rightIconPaddingLeft = left
        rightIconPaddingTop = top
        rightIconPaddingRight = right
        rightIconPaddingBottom = bottom

        itemRightIcon.setPadding(
            rightIconPaddingLeft.toInt(),
            rightIconPaddingTop.toInt(),
            rightIconPaddingRight.toInt(),
            rightIconPaddingBottom.toInt()
        )

    }

    /**
     * 设置RightIcon 左边的填充像素
     */
    public fun setRightIconPaddingLeft(left: Float) {
        setRightIconPadding(left, 0.0F, 0.0F, 0.0F)
    }

    /**
     * 设置RightIcon 上边的填充像素
     */
    public fun setRightIconPaddingTop(top: Float) {
        setRightIconPadding(0.0F, top, 0.0F, 0.0F)
    }

    /**
     * 设置RightIcon左边的填充像素
     */
    public fun setRightIconPaddingRight(right: Float) {
        setRightIconPadding(0.0F, 0.0F, right, 0.0F)
    }

    /**
     * 设置RightIcon 的下边距（外部）
     */
    public fun setRighttIconPaddingBottom(bottom: Float) {
        setRightIconPadding(0.0F, 0.0f, 0.0f, bottom)
    }


    /***************设置右边主文本控件的相关方法***************************************************************************
     *
     * 设置左边主文本控件的内容
     */
    public fun setRightText(text: String?) {
        rightText = text
        itemRightText.text = rightText
    }

    public fun setRightTextBackgroundResource(resId: Int) {
        rightTextBackgroundResource = resId
        itemRightText.setBackgroundResource(rightTextBackgroundResource)
    }


    /**
     * @param size 缩放像素大小
     */
    public fun setRightTextSize(size: Float) {
        setRightTextSize(TypedValue.COMPLEX_UNIT_SP, context.px2sp(size).toFloat())
    }

    /**
     * 给定单位的字体大小
     */
    public fun setRightTextSize(unit: Int, size: Float) {
        rightTextSize = size
        itemRightText.setTextSize(unit, rightTextSize)
    }

    /**
     * 缩放像素大小
     */
    public fun getRightTextSize(): Float {
        return rightTextSize
    }


    /**
     * 设置右边主文本的左边距（外部）
     */
    public fun setRightTextMarginLeft(rightMargin: Float) {
        rightTextMarginLeft = rightMargin
        rightTextParams.leftMargin = rightTextMarginLeft.toInt()
        itemRightText.layoutParams = rightTextParams
    }

    /**
     * 设置RightText 的上边距 外部
     */
    public fun setRightTextMarginTop(topMargin: Float) {
        rightTextMarginTop = topMargin
        rightTextParams.topMargin = rightTextMarginTop.toInt()
        itemRightText.layoutParams = rightTextParams
    }

    /**
     * 设置RightText的右边距（外部）
     */
    public fun setRightTextMarginRight(rightMargin: Float) {
        rightTextMarginRight = rightMargin
        rightTextParams.rightMargin = rightTextMarginRight.toInt()
        itemRightText.layoutParams = rightTextParams
    }

    /**
     * RightText 的下边距（外部）
     */
    public fun setRightTextMarginBottom(bottomMargin: Float) {
        rightTextMarginBottom = bottomMargin
        rightTextParams.bottomMargin = rightTextMarginBottom.toInt()
        itemRightText.layoutParams = rightTextParams
    }

    /**
     * 设置RightText 的内边距
     */
    public fun setRightTextPadding(left: Float, top: Float, right: Float, bottom: Float) {
        rightTextPaddingLeft = left
        rightTextPaddingTop = top
        rightTextPaddingRight = right
        rightTextPaddingBottom = bottom
        itemRightText.setPadding(
            rightTextPaddingLeft.toInt(),
            rightTextPaddingTop.toInt(),
            rightTextPaddingRight.toInt(),
            rightTextPaddingBottom.toInt()
        )
    }

    /**
     * 设置RightText 左边的填充像素
     */
    public fun setRightTextPaddingLeft(left: Float) {
        setRightTextPadding(left, 0.0F, 0.0F, 0.0F)
    }

    /**
     * 设置RightText 上边的填充像素
     */
    public fun setRightTextPaddingTop(top: Float) {
        setRightTextPadding(0.0F, top, 0.0F, 0.0F)
    }

    /**
     * 设置RightText 左边的填充像素
     */
    public fun setRightTextPaddingRight(right: Float) {
        setRightTextPadding(0.0F, 0.0F, right, 0.0F)
    }
    /**
     * 设置RightText 的下边距（外部）
     */
    public fun setRightTextPaddingBottom(bottom: Float) {
        setRightTextPadding(0.0F, 0.0f, 0.0f, bottom)
    }


    /***************设置右边次文本控件的相关方法***************************************************************************
     *
     * 设置RightSubText控件的内容
     */
    public fun setRightSubText(text: String?) {
        rightSubText = text
        itemRightSubText.text = rightSubText
    }

    /**
     * @param size 缩放像素大小
     */
    public fun setRightSubTextSize(size: Float) {
        setRightSubTextSize(TypedValue.COMPLEX_UNIT_SP, context.px2sp(size).toFloat())
    }

    /**
     * 给定单位的字体大小
     */
    public fun setRightSubTextSize(unit: Int, size: Float) {
        rightSubTextSize = size
        itemRightSubText.setTextSize(unit, rightSubTextSize)
    }

    /**
     * 缩放像素大小
     */
    public fun getRightSubTextSize(): Float {
        return rightSubTextSize
    }

    /**
     * 设置RightSubText的左边距（外部）
     */
    public fun setRightSubTextMarginLeft(rightMargin: Float) {
        rightSubTextMarginLeft = rightMargin
        rightSubTextParams.leftMargin = rightSubTextMarginLeft.toInt()
        itemRightSubText.layoutParams = rightSubTextParams
    }

    /**
     * 设置RightSubText 的上边距 外部
     */
    public fun setRightSubTextMarginTop(topMargin: Float) {
        rightSubTextMarginTop = topMargin
        rightSubTextParams.topMargin = rightTextMarginTop.toInt()
        itemRightSubText.layoutParams = rightTextParams
    }

    /**
     * 设置RightSubText的右边距（外部）
     */
    public fun setRightSubTextMarginRight(rightMargin: Float) {
        rightSubTextMarginRight = rightMargin
        rightSubTextParams.rightMargin = rightSubTextMarginRight.toInt()
        itemRightSubText.layoutParams = rightSubTextParams
    }

    /**
     * RightSubText 的下边距（外部）
     */
    public fun setRightSubTextMarginBottom(bottomMargin: Float) {
        rightSubTextMarginBottom = bottomMargin
        rightSubTextParams.bottomMargin = rightSubTextMarginBottom.toInt()
        itemRightSubText.layoutParams = rightSubTextParams
    }

    /**
     * Set the visibility state of this view.
     *
     * @param visibility One of {@link #VISIBLE}, {@link #INVISIBLE}, or {@link #GONE}.
     * @attr ref android.R.styleable#View_visibility
     */
    public fun setRightSubTextVisible(visibility: Int) {
        itemRightSubText.visibility = when (visibility) {
            0 -> View.VISIBLE
            1 -> View.INVISIBLE
            else -> View.GONE
        }
    }

    /**
     * 设置RightSubText 的内边距
     */
    public fun setRightSubTextPadding(left: Float, top: Float, right: Float, bottom: Float) {
        rightSubTextPaddingLeft = left
        rightSubTextPaddingTop = top
        rightSubTextPaddingRight = right
        rightSubTextPaddingBottom = bottom
        itemRightSubText.setPadding(
            rightSubTextPaddingLeft.toInt(),
            rightSubTextPaddingTop.toInt(),
            rightSubTextPaddingRight.toInt(),
            rightSubTextPaddingBottom.toInt()
        )
    }

    /**
     * 设置RightSubText 左边的填充像素
     */
    public fun setRightSubTextPaddingLeft(left: Float) {
        setRightSubTextPadding(left, 0.0F, 0.0F, 0.0F)
    }

    /**
     * 设置RightSubText 上边的填充像素
     */
    public fun setRightSubTextPaddingTop(top: Float) {
        setRightSubTextPadding(0.0F, top, 0.0F, 0.0F)
    }

    /**
     * 设置RightSubText 左边的填充像素
     */
    public fun setRightSubTextPaddingRight(right: Float) {
        setRightSubTextPadding(0.0F, 0.0F, right, 0.0F)
    }

    /**
     * 设置RightSubText 的下边距（外部）
     */
    public fun setRightSubTextPaddingBottom(bottom: Float) {
        setRightSubTextPadding(0.0F, 0.0f, 0.0f, bottom)
    }

    /**
     * 设置RightSubText的背景
     */
    public fun setRightSubTextBackgroundResource(resId: Int) {
        rightSubTextBackgroundResource = resId
        itemRightSubText.setBackgroundResource(resId)
    }


    /***************设置UnreadMessage的相关方法***************************************************************************
     *
     * 设置rightUnreadMessage控件的内容
     */
    public fun setRightUnreadMessage(text: String?) {
        rightUnreadMessage = text
        itemRightUnreadMessage.text = rightUnreadMessage
    }

    /**
     * RightUnreadMessage的背景
     */
    public fun setRightUnreadMessageBackgroundResource(resId: Int) {
        rightUnreadMessageBackgroundResource = resId
        itemRightUnreadMessage.setBackgroundResource(rightUnreadMessageBackgroundResource)
    }

    /**
     * 设置rightUnreadMessage的左边距（外部）
     */
    public fun setRightUnreadMessageMarginLeft(leftMargin: Float) {
        rightUnreadMessageMarginLeft = leftMargin
        rightUnreadMessageParams.leftMargin = rightUnreadMessageMarginLeft.toInt()
        itemRightUnreadMessage.layoutParams = rightUnreadMessageParams
    }

    /**
     * 设置rightUnreadMessage 的上边距 外部
     */
    public fun setRightUnreadMessageMarginTop(topMargin: Float) {
        rightUnreadMessageMarginTop = topMargin
        rightUnreadMessageParams.topMargin = rightUnreadMessageMarginTop.toInt()
        itemRightUnreadMessage.layoutParams = rightUnreadMessageParams
    }

    /**
     * 设置rightUnreadMessage的右边距（外部）
     */
    public fun setRightUnreadMessageMarginRight(rightMargin: Float) {
        rightUnreadMessageMarginRight = rightMargin
        rightUnreadMessageParams.rightMargin = rightUnreadMessageMarginRight.toInt()
        itemRightUnreadMessage.layoutParams = rightUnreadMessageParams
    }

    /**
     * rightUnreadMessage 的下边距（外部）
     */
    public fun setRightUnreadMessageMarginBottom(bottomMargin: Float) {
        rightUnreadMessageMarginBottom = bottomMargin
        rightUnreadMessageParams.bottomMargin = rightUnreadMessageMarginBottom.toInt()
        itemRightUnreadMessage.layoutParams = rightUnreadMessageParams
    }

    /**
     * 设置rightUnreadMessage 的内边距
     */
    public fun setRightUnreadMessagePadding(left: Float, top: Float, right: Float, bottom: Float) {
        rightUnreadMessagePaddingLeft = left
        rightUnreadMessagePaddingTop = top
        rightUnreadMessagePaddingRight = right
        rightUnreadMessagePaddingBottom = bottom
        itemRightUnreadMessage.setPadding(
            rightUnreadMessagePaddingLeft.toInt(),
            rightUnreadMessagePaddingTop.toInt(),
            rightUnreadMessagePaddingRight.toInt(),
            rightUnreadMessagePaddingBottom.toInt()
        )
    }

    /**
     * 设置rightUnreadMessage 左边的填充像素
     */
    public fun setRightUnreadMessagePaddingLeft(left: Float) {
        setRightUnreadMessagePadding(left, 0.0F, 0.0F, 0.0F)
    }

    /**
     * 设置rightUnreadMessage 上边的填充像素
     */
    public fun setRightUnreadMessagePaddingTop(top: Float) {
        setRightUnreadMessagePadding(0.0F, top, 0.0F, 0.0F)
    }

    /**
     * 设置rightUnreadMessage 左边的填充像素
     */
    public fun setRightUnreadMessagePaddingRight(right: Float) {
        setRightUnreadMessagePadding(0.0F, 0.0F, right, 0.0F)
    }

    /**
     * 设置rightUnreadMessage 的下边距（外部）
     */
    public fun setRightUnreadMessagePaddingBottom(bottom: Float) {
        setRightUnreadMessagePadding(0.0F, 0.0f, 0.0f, bottom)
    }

    /**
     * @param size 缩放像素大小
     */
    public fun setRightUnreadMessageTextSize(size: Float) {
        setRightUnreadMessageTextSize(TypedValue.COMPLEX_UNIT_SP, context.px2sp(size).toFloat())
    }

    /**
     * 给定单位的字体大小
     */
    public fun setRightUnreadMessageTextSize(unit: Int, size: Float) {
        rightUnreadMessageTextSize = size
        itemRightUnreadMessage.setTextSize(unit, rightUnreadMessageTextSize)
    }

    /**
     * 缩放像素大小
     */
    public fun getRightUnreadMessageTextSize(): Float {
        return rightUnreadMessageTextSize
    }


    public fun setLeftTextColor(color: Int) {
        leftTextColor = color
        itemLeftText.setTextColor(leftTextColor)
    }

    public fun setLeftSubTextColor(color: Int) {
        leftSubTextColor = color
        itemLeftSubText.setTextColor(leftSubTextColor)
    }

    public fun setRightTextColor(color: Int) {
        rightTextColor = color
        itemRightText.setTextColor(rightTextColor)
    }

    public fun setRightSubTextColor(color: Int) {
        rightSubTextColor = color
        itemRightSubText.setTextColor(rightSubTextColor)
    }

    public fun setRightUnreadMessageTextColor(color: Int) {
        rightUnreadMessageTextColor = color
        itemRightUnreadMessage.setTextColor(rightUnreadMessageTextColor)
    }


    public fun setBottomLineBackground(resId: Int) {
        itemBottomLine.setBackgroundColor(resId)
    }

    /**
     * 设置左边距
     * @param leftMargin 左边距
     */
    public fun setBottomLineMarginLeft(leftMargin: Float) {
        bottomLineParams.leftMargin = leftMargin.toInt()
        itemBottomLine.layoutParams = bottomLineParams
    }

    public fun setBottomLineMarginRight(rightMargin: Float) {
        bottomLineParams.rightMargin = rightMargin.toInt()
        itemBottomLine.layoutParams = bottomLineParams
    }

    public fun setBottomLineMarginTop(topMargin: Float) {
        bottomLineParams.topMargin = topMargin.toInt()
        itemBottomLine.layoutParams = bottomLineParams
    }

    public fun setBottomLineMarginBottom(bottomMargin: Float) {
        bottomLineParams.bottomMargin = bottomMargin.toInt()
        itemBottomLine.layoutParams = bottomLineParams
    }

    public fun setBottomLinePadding(left: Float, top: Float, right: Float, bottom: Float) {
        itemBottomLine.setPadding(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())
    }

    public fun setBottomLinePaddingLeft(left: Float) {
        setBottomLinePadding(left, 0.0F, 0.0F, 0.0F)
    }

    public fun setBottomLinePaddingTop(top: Float) {
        setBottomLinePadding(0.0F, top, 0.0F, 0.0F)
    }

    public fun setBottomLinePaddingRight(right: Float) {
        setBottomLinePadding(0.0F, 0.0F, right, 0.0F)
    }

    public fun setBottomLinePaddingBottom(bottom: Float) {
        setBottomLinePadding(0.0F, 0.0F, 0.0F, bottom)
    }

    /**
     * 设置是否可见
     */
    public fun setBottomLineVisibility(visibility: Int) {
        itemBottomLine.visibility = when (visibility) {
            0 -> View.VISIBLE
            1 -> View.INVISIBLE
            else -> View.GONE
        }
    }

}