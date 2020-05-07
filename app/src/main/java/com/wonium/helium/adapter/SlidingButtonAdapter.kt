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


package com.wonium.helium.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.helium.android.SlidingButtonView
import com.helium.android.SlidingButtonView.SlidingButtonListener
import com.wonium.helium.R
import com.wonium.helium.adapter.SlidingButtonAdapter.MyViewHolder
import com.wonium.helium.helper.screenWidth
import java.util.*

/**
* @Description:
* @Author: Ethan
* @E-mail: wonium@qq.com
* @Blog: https://blog.wonium.com
* @CreateDate: 2020/2/26 23:03
* @UpdateUser: Ethan
* @UpdateDate:  2020/2/26 23:03
* @UpdateDescription: 更新说明
* @Version: 1.0.0
*/

class SlidingButtonAdapter(private val mContext: Context) : RecyclerView.Adapter<MyViewHolder>(), SlidingButtonListener {
    private val mIDeleteBtnClickListener: SlidingViewClickListener
    private val mDatas: MutableList<String> = ArrayList()
    private var mMenu: SlidingButtonView? = null
    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = mDatas[position]
        holder.layout_content.layoutParams.width =holder.itemView.context.screenWidth()
        holder.textView.setOnClickListener { v ->
            if (menuIsOpen()) {
                closeMenu()
            } else {
                val n = holder.layoutPosition
                mIDeleteBtnClickListener.onItemClick(v, n)
            }
        }
        holder.btn_Delete.setOnClickListener { v: View? ->
            val n = holder.layoutPosition
            mIDeleteBtnClickListener.onDeleteBtnClick(v, n)
        }
    }

    override fun onCreateViewHolder(arg0: ViewGroup, arg1: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_sliding_item, arg0, false)
        return MyViewHolder(view)
    }

    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var btn_Delete: TextView
        var textView: TextView
        var layout_content: ViewGroup

        init {
            btn_Delete = itemView.findViewById<View>(R.id.labelDelete) as TextView
            textView = itemView.findViewById<View>(R.id.text) as TextView
            layout_content = itemView.findViewById<View>(R.id.layout_content) as ViewGroup
            (itemView as SlidingButtonView).setSlidingButtonListener(this@SlidingButtonAdapter)
        }
    }

    fun addData(position: Int) {
        mDatas.add(position, position.toString())
        notifyItemInserted(position)
    }

    fun removeData(position: Int) {
        mDatas.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onMenuIsOpen(view: View?) {
        mMenu = view as SlidingButtonView?
    }

    override fun onDownOrMove(slidingButtonView: SlidingButtonView?) {
        if (menuIsOpen()) {
            if (mMenu != slidingButtonView) {
                closeMenu()
            }
        }
    }

    fun closeMenu() {
        mMenu!!.closeMenu()
        mMenu = null
    }

    fun menuIsOpen(): Boolean {
        if (mMenu != null) {
            return true
        }
        Log.i("asd", "mMenuΪnull")
        return false
    }

    interface SlidingViewClickListener {
        fun onItemClick(view: View?, position: Int)
        fun onDeleteBtnClick(view: View?, position: Int)
    }

    init {
        mIDeleteBtnClickListener = mContext as SlidingViewClickListener
        for (i in 0..9) {
            mDatas.add(i.toString() + "")
        }
    }
}

