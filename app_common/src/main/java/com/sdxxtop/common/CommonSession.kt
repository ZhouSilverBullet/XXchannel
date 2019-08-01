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
    private lateinit var contextDef: WeakReference<Context>
    lateinit var AUTHORITY: String;

    /**
     * authority -> FileProvider 中的字符串
     */
    fun initCommon(context: Context, authority: String) {
        this@CommonSession.contextDef = WeakReference(context)
        this@CommonSession.AUTHORITY = authority
    }

    @JvmStatic
    fun getContext(): Context {
        if (contextDef.get() == null) {
            throw IllegalAccessException("CommonSession需要被初始化，用于获取资源等...")
        }
        return contextDef.get()!!
    }

}