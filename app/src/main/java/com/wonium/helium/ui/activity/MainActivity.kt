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
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.helium.android.NoticeView
import com.helium.helper.CleanCacheHelper
import com.wonium.helium.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { showNoticeView() }
        button2.setOnClickListener { showAtLocation() }
        button3.setOnClickListener {
            startActivity(Intent(baseContext, ItemViewActivity::class.java))
        }
        button4.setOnClickListener {
            startActivity(Intent(baseContext, SlidingButtonActivity::class.java))
        }
        btnColorFulLine.setOnClickListener {
            startActivity(Intent(baseContext, ColorFulLineActivity::class.java))
        }
        btnEdit.setOnClickListener { startActivity(Intent(baseContext, EditActivity::class.java)) }
        tvAppCache.text =CleanCacheHelper.getTotalCacheSize(baseContext)
        btnCleanCache.setOnClickListener{
            CleanCacheHelper.clearAllCache(baseContext)
            tvAppCache.text =CleanCacheHelper.getTotalCacheSize(baseContext)
        }

    }

    private fun showNoticeView() {
        NoticeView.Builder(this).setNotice("跳过图片题").create().showAsDropDown(button)
    }

    private fun showAtLocation() {
        NoticeView.Builder(this).setNotice("显示在状态栏下方").setDismissDelayed(5000).create().showAtLocation(this.window.decorView, Gravity.TOP, 0, 100)
    }

}
