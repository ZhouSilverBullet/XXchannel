package com.sdxxtop.common

import android.content.Context
import java.lang.ref.WeakReference

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-30 09:01
 * Version: 1.0
 * Description:
 */
object CommonSession {
    lateinit var contextDef: WeakReference<Context>
    var version: Int = 0


    fun initCommon(context: Context, version: Int) {
        this@CommonSession.contextDef = WeakReference(context)
        this@CommonSession.version = version
    }

    @JvmStatic
    fun getContext(): Context {
        return contextDef.get()!!
    }
}