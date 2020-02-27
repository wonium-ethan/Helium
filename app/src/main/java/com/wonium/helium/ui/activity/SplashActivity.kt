/*
 *   Copyright (c) 2020. Ethan
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.wonium.helium.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.core.os.postDelayed
import com.wonium.helium.App
import com.wonium.helium.R
import com.wonium.helium.config.Constants

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
                           startActivity(Intent(baseContext, MainActivity::class.java))
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