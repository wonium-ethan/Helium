package com.wonium.widget

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.helium.android.NoticeView
import com.wonium.widget.ui.activity.ColorFulLineActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { showNoticeView() }
        button2.setOnClickListener { showAtLocation() }
        button3.setOnClickListener { startActivity(Intent(baseContext, ItemViewActivity::class.java)) }
        button4.setOnClickListener { startActivity(Intent(baseContext, SlidingButtonActivity::class.java)) }
        btnColorFulLine.setOnClickListener { startActivity(Intent(baseContext,ColorFulLineActivity::class.java)) }
    }

    private fun showNoticeView() {
        NoticeView.Builder(this).setNotice("跳过图片题").create().showAsDropDown(button)
    }

    private fun showAtLocation() {
        NoticeView.Builder(this).setNotice("显示在状态栏下方").setDismissDelayed(5000).create().showAtLocation(this.window.decorView, Gravity.TOP, 0, 100)
    }


}
