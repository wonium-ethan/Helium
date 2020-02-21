package com.wonium.widget.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.core.os.postDelayed
import com.wonium.widget.App
import com.wonium.widget.MainActivity
import com.wonium.widget.R
import com.wonium.widget.config.Constants

/**
 * @ClassName:
 * @Description: 开启ADB页面
 * @Author: fxhhq
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2020/2/19 15:38
 * @UpdateUser: Ethan
 * @UpdateDate: 2020/2/19 15:38
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        uiHandler.postDelayed(Constants.DIALOG_DISMISS_TIMEOUT) {
            if(App.Instance.sharedPreferences.isFirstOpen){
               GuidePage.load(intArrayOf(R.mipmap.guide_page_1,R.mipmap.guide_page_2,R.mipmap.guide_page_3,R.mipmap.guide_page_4))
                   .pageDoneDrawableResource(R.mipmap.btn_done)
                   .indicatorDrawableResource(R.drawable.gp_indicator_drawable)
                   .indicatorSize(baseContext,dpSize = 6f)
                   .showSkip(showSkip = true)
                   .lastPageHideSkip(lastPageHideSkip = true)
                   .onGuidePageChangeCallback(object : GuidePage.OnGuidePageChangeCallback {
                       override fun onPageDone(skip: Boolean) {
                           App.Instance.sharedPreferences.isFirstOpen=false
                           startActivity(Intent(baseContext,MainActivity::class.java))
                           finish()
                       }

                   }).start(this)
            }else{
                startActivity(Intent(baseContext, MainActivity::class.java))
                finish()
            }

        }
    }

}