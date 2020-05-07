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

package com.wonium.helium.config

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