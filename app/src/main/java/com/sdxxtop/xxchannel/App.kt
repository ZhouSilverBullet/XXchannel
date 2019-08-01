package com.sdxxtop.xxchannel

import android.content.Context
import android.util.Log
import com.baidu.idl.face.FaceSession
import com.sdxxtop.base.BaseApplication
import com.sdxxtop.common.CommonSession
import com.sdxxtop.network.NetworkSession
import com.sdxxtop.sdk.AnalyticsSession
import com.sdxxtop.sdk.MapSession
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
        CommonSession.initCommon(this, "$packageName.provider")
        //初始化network模块
        NetworkSession.initNetwork(this, BuildConfig.VERSION_CODE)
        //初始化地图
        MapSession.initAMap(this)

        FaceSession.initFace(this, "licenseID")

        //友盟统计
        AnalyticsSession.initAnalytics(this, BuildConfig.DEBUG, "5d4245600cafb2f31f0009f5")

        Log.i(TAG, "--------------调取-------------->")
    }
}