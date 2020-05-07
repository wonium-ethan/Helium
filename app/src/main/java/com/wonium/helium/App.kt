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


package com.wonium.helium

import android.app.Application
import android.content.Context
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager

import com.wonium.helium.config.Constants
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @ClassName:
 * @Description:
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
        lateinit var Instance: App
    }
    init {
        Instance =this
    }

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    val sharedPreferences: SharedPreferences by lazy { SharedPreferences(Instance) }

    override fun onCreate() {
        super.onCreate()
        QMUISwipeBackActivityManager.init(this)

        logger.error("LOG:Application:onCreate =================================================================================")
        logger.debug("LOG:Application:onCreate content=debug !!! this log should remove !!!")
        logger.trace("LOG:Application:onCreate content=trace !!! this log should remove !!!")
        logger.info("LOG:Application:onCreate content=info  !!! this log should remove !!!")
        logger.warn("LOG:Application:onCreate content=warn  !!! this log should remove !!!")
        logger.error("LOG:Application:onCreate content=error !!! this log should remove !!!")
        logger.info("LOG:Application:onCreate apk build time={}", BuildConfig.BUILD_TIME)
//        logger.info("LOG:Application:onCreate remoteServerHost={}", Instance.sharedPreferences.remoteServerHost)
        logger.error("LOG:Application:onCreate =================================================================================")


    }

    @Suppress(names = ["DEPRECATION"])
    inner class SharedPreferences(context: Context) {
        private val raw: android.content.SharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(context)
        var isFirstOpen: Boolean
            get() = raw.getBoolean(Constants.PREFERENCE_KEY_IS_FIRST_OPEN, true)
            set(value) = raw.edit().putBoolean(Constants.PREFERENCE_KEY_IS_FIRST_OPEN, value).apply()
    }

}