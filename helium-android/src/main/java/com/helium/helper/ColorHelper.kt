package com.helium.helper

import android.graphics.Color
import kotlin.math.sqrt

/**
 * @ClassName:
 * @Description:
 * @Author: Ethan
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2020/2/26 22:20
 * @UpdateUser: Ethan
 * @UpdateDate: 2020/2/26 22:20
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */

/**
 * 判断颜色是否为亮色
 * @param color 颜色值
 */
fun Color.isLight(color: Int): Boolean = sqrt(Color.red(color) * Color.red(color) * 0.241 + Color.green(color) * Color.green(color) * 0.691 + Color.blue(color) * Color.blue(color) * 0.068) > 130
