package com.wonium.android.widget

import android.content.Context
import android.os.Handler
import android.view.*
import android.widget.PopupWindow
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
class NoticeView(builder: Builder) {
    private var notice: String? = null

    init {
        this.notice = builder.getNotice()
    }

    class Builder(private val context: Context) : PopupWindow.OnDismissListener {
        override fun onDismiss() {

            Handler().postDelayed({ mPopupWindow.dismiss() }, delayed)
        }

        private var notice: String? = null
        private var alpha = 0.7f
        private lateinit var mPopupWindow: PopupWindow
        private lateinit var onDismissListener: PopupWindow.OnDismissListener
        private var delayed: Long = 1000
        private var animationStyle= R.style.NoticeViewAnimation


        fun setDismissTime(delayed: Long) :Builder{
            this.delayed = delayed
            return this
        }

        public fun setNotice(string: String): Builder {
            this.notice = string
            return this
        }

        fun getNotice(): String? {
            return notice
        }

        fun setAnimationStyle(animationStyle:Int){
            this.animationStyle =animationStyle
        }
        fun create(): Builder {
            val layoutNoticeView =
                LayoutInflater.from(context).inflate(R.layout.layout_notice_view, null)
            layoutNoticeView.labelNoticeView.text = notice
            val activity: AppCompatActivity = layoutNoticeView.context as AppCompatActivity
            val mWindow = activity.window
            val params: WindowManager.LayoutParams = mWindow.attributes
            params.alpha = alpha
            mWindow.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            mWindow.attributes = params
            mPopupWindow = PopupWindow(
                layoutNoticeView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            mPopupWindow.animationStyle =animationStyle
            onDismissListener =this
            mPopupWindow.setOnDismissListener(onDismissListener)

            return this
        }

        fun showAsDropDown(anchor: View) {
            mPopupWindow.showAsDropDown(anchor)
            onDismissListener.onDismiss()
        }
        fun showAtLocation(parent:View,gravity:Int,x:Int,y:Int){
            mPopupWindow.showAtLocation(parent,Gravity.TOP,x,y)
            onDismissListener.onDismiss()

        }

    }


}