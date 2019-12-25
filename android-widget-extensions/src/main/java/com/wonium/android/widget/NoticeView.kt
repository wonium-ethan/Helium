package com.wonium.android.widget

import android.content.Context
import android.os.Handler
import android.view.*
import android.widget.PopupWindow
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.wonium.android.R
import kotlinx.android.synthetic.main.layout_notice_view.view.*

/**
 * @ClassName:
 * @Description: 开启ADB页面
 * @Author: fxhhq
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2019/12/24 20:39
 * @UpdateUser: Ethan
 * @UpdateDate: 2019/12/24 20:39
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */
class NoticeView(private val builder: Builder) : PopupWindow.OnDismissListener {


    private lateinit var mPopupWindow: PopupWindow
    private lateinit var onDismissListener: PopupWindow.OnDismissListener


    init {
        val layoutNoticeView =
            LayoutInflater.from(builder.context).inflate(R.layout.layout_notice_view, null)
        layoutNoticeView.labelNoticeView.text = builder.notice
        val activity: AppCompatActivity = layoutNoticeView.context as AppCompatActivity
        val mWindow = activity.window
        val params: WindowManager.LayoutParams = mWindow.attributes
        mWindow.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        mWindow.attributes = params
        mPopupWindow = PopupWindow(
            layoutNoticeView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        mPopupWindow.animationStyle = builder.animationStyle
        onDismissListener = this
        mPopupWindow.setOnDismissListener(onDismissListener)
        mPopupWindow.contentView.setBackgroundResource(builder.resId)

    }

    fun showAsDropDown(anchor: View) {
        mPopupWindow.showAsDropDown(anchor)
        onDismissListener.onDismiss()
    }

    fun showAtLocation(parent: View, gravity: Int, x: Int, y: Int) {
        mPopupWindow.showAtLocation(parent, Gravity.TOP, x, y)
        onDismissListener.onDismiss()

    }


    override fun onDismiss() {

        Handler().postDelayed({ mPopupWindow.dismiss() }, builder.delayed)
    }

    class Builder(val context: Context) {
        internal var notice: String? = null
        internal var animationStyle = R.style.NoticeViewAnimation
        internal var delayed: Long = 1000
        internal var resId = R.drawable.bg_notice_view

        fun setDismissDelayed(delayed: Long): Builder {
            this.delayed = delayed
            return this
        }

        fun setNotice(string: String): Builder {
            this.notice = string
            return this
        }

        fun getNotice(): String? {
            return notice
        }

        fun setAnimationStyle(animationStyle: Int): Builder {
            this.animationStyle = animationStyle
            return this
        }

        fun setBackgroundResource(@DrawableRes resId: Int): Builder {
            this.resId = resId
            return this
        }

        fun create(): NoticeView = NoticeView(this)
    }


}