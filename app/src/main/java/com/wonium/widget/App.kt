package com.wonium.widget

import android.app.Application
import android.content.Context
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager
import com.wonium.widget.config.Constants

/**
 * @ClassName:
 * @Description: 开启ADB页面
 * @Author: fxhhq
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2020/1/2 20:11
 * @UpdateUser: Ethan
 * @UpdateDate: 2020/1/2 20:11
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */

class App : Application() {

    companion object{
        lateinit var Instance:App
    }
    init {
        Instance =this
    }
    val sharedPreferences:SharedPreferences by lazy { SharedPreferences(Instance) }

    override fun onCreate() {
        super.onCreate()
        QMUISwipeBackActivityManager.init(this)
    }

    @Suppress(names = ["DEPRECATION"])
    inner class SharedPreferences(context: Context) {
        private val raw: android.content.SharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(context)
        var isFirstOpen: Boolean
            get() = raw.getBoolean(Constants.PREFERENCE_KEY_IS_FIRST_OPEN, true)
            set(value) = raw.edit().putBoolean(Constants.PREFERENCE_KEY_IS_FIRST_OPEN, value).apply()
    }

}