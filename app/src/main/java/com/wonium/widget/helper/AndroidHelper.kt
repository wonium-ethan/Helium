package com.wonium.widget.helper

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * @ClassName:
 * @Description: 开启ADB页面
 * @Author: fxhhq
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2019/12/29 22:37
 * @UpdateUser: Ethan
 * @UpdateDate: 2019/12/29 22:37
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */


 fun Context.screenWidth():Int{
    val wm: WindowManager =this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val outMetrics = DisplayMetrics()
    wm.defaultDisplay.getMetrics(outMetrics)
    return  outMetrics.widthPixels
}
