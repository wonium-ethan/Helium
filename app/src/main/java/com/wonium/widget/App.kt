package com.wonium.widget

import android.app.Application
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager

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
    override fun onCreate() {
        super.onCreate()
        QMUISwipeBackActivityManager.init(this)
    }
}