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

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.wonium.helium.R
import com.wonium.helium.adapter.SlidingButtonAdapter
import kotlinx.android.synthetic.main.activity_sliding_button.*

/**
 * @ClassName: MainActivity
 * @Description: 描述一下
 * @Author: Ethan
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2019/3/27 22:08
 * @UpdateUser: update user
 * @UpdateDate: 2019/3/27 22:08
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */
class SlidingButtonActivity : AppCompatActivity(), SlidingButtonAdapter.SlidingViewClickListener{

    private var mAdapter: SlidingButtonAdapter? = null
    private val TAG = "test"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_button)
        setAdapter()
    }



    private fun setAdapter() {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = SlidingButtonAdapter(this).also { mAdapter = it }
        recycler.itemAnimator = DefaultItemAnimator()
    }

    override fun onItemClick(view: View?, position: Int) {
        Log.i(TAG, "item$position")
    }

    override fun onDeleteBtnClick(view: View?, position: Int) {
        Log.i(TAG, "onDele$position")
        mAdapter!!.removeData(position)
    }


}