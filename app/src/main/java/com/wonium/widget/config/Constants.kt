package com.wonium.widget.config

import java.util.concurrent.TimeUnit

/**
 * @ClassName:
 * @Description: 开启ADB页面
 * @Author: fxhhq
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2020/2/19 15:49
 * @UpdateUser: Ethan
 * @UpdateDate: 2020/2/19 15:49
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */
class Constants {
    companion object{
        val DIALOG_DISMISS_TIMEOUT=TimeUnit.SECONDS.toMillis(3)
        const val PREFERENCE_KEY_IS_FIRST_OPEN:String ="perference_key_is_first_open"
    }
}