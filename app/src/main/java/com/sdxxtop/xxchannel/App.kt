package com.sdxxtop.xxchannel

import android.util.Log
import com.sdxxtop.base.BaseApplication
import com.sdxxtop.common.CommonSession

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-29 17:41
 * Version: 1.0
 * Description:
 */
class App : BaseApplication() {
    val TAG = "CCApp"
    override fun onCreate() {
        super.onCreate()
        //要把common层进行初始化
        CommonSession.initCommon(this, BuildConfig.VERSION_CODE)
        Log.i(TAG, "--------------调取-------------->")
    }
}