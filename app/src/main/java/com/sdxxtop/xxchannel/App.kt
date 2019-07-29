package com.sdxxtop.xxchannel

import android.app.Application
import android.util.Log

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-29 17:41
 * Version: 1.0
 * Description:
 */
class App : Application() {
    val TAG = "CCApp"
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "--------------调取-------------->")
    }
}