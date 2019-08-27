package com.sdxxtop.xxchannel

import android.content.Context
import android.util.Log
import com.baidu.idl.face.FaceSession
import com.sdxxtop.analysis.impl.ActivityLifecycleListener
import com.sdxxtop.analysis.TrackPoint
import com.sdxxtop.analysis.callback.TrackPointCallBack
import com.sdxxtop.base.BaseApplication
import com.sdxxtop.common.CommonSession
import com.sdxxtop.crash.CrashSession
import com.sdxxtop.mapsdk.MapSession
import com.sdxxtop.network.NetworkSession
import com.sdxxtop.sdk.AnalyticsSession
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
        CommonSession.initCommon(this, "$packageName.provider", isDebug())
        //初始化network模块
        NetworkSession.initNetwork(this, BuildConfig.VERSION_CODE)
        //初始化地图
        MapSession.initAMap(this)

        FaceSession.initFace(this, "licenseID")

        //友盟统计
        AnalyticsSession.initAnalytics(this, isDebug(), "5d4245600cafb2f31f0009f5")

        //crash 初始化
        CrashSession.initCrash(this, isDebug(), BuildConfig.VERSION_NAME)

        Log.i(TAG, "--------------调取-------------->")

        TrackPoint.init()

        registerActivityLifecycleCallbacks(ActivityLifecycleListener())

    }

    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

}