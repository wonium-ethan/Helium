package com.wonium.widget.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

/**
 * @ClassName:
 * @Description: 开启ADB页面
 * @Author: fxhhq
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2020/2/19 15:39
 * @UpdateUser: Ethan
 * @UpdateDate: 2020/2/19 15:39
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */
abstract class BaseActivity :AppCompatActivity() {

   protected val uiHandler: Handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}