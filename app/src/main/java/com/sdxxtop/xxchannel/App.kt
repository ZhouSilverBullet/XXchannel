package com.sdxxtop.xxchannel

import android.content.Context
import android.util.Log
import com.sdxxtop.base.BaseApplication
import com.sdxxtop.common.CommonSession
import com.sdxxtop.network.NetworkSession
import kotlin.properties.Delegates

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-29 17:41
 * Version: 1.0
 * Description:
 */
class App : BaseApplication() {
    companion object {
        @JvmStatic
        var INSTANCE: Context by Delegates.notNull()
    }


    val TAG = "CCApp"
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        //要把common层进行初始化
        CommonSession.initCommon(this)
        //初始化network模块
        NetworkSession.initNetwork(this, BuildConfig.VERSION_CODE)

        Log.i(TAG, "--------------调取-------------->")
    }
}