package com.sdxxtop.crash

import android.content.Context

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-08-01 18:46
 * Version: 1.0
 * Description:
 */
/**
 * 异常处理
 */
class CrashHandler//构造方法私有，防止外部构造多个实例，即采用单例模式
private constructor() : Thread.UncaughtExceptionHandler {

    //系统默认的异常处理（默认情况下，系统会终止当前的异常程序）
    private var mDefaultCrashHandler: Thread.UncaughtExceptionHandler? = null

    private var mContext: Context? = null

    //这里主要完成初始化工作
    fun init(context: Context) {
        //获取系统默认的异常处理器
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler()
        //将当前实例设为系统默认的异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this)
        //获取Context，方便内部使用
        mContext = context.applicationContext
    }


    /**
     * 当程序中有未被捕获的异常，系统将会自动调用#uncaughtException方法
     * thread为出现未捕获异常的线程，ex为未捕获的异常，有了这个ex，我们就可以得到异常信息。
     */
    override fun uncaughtException(thread: Thread, ex: Throwable) {

        //如果系统提供了默认的异常处理器，则交给系统去结束我们的程序，否则就由我们自己结束自己
        if (mDefaultCrashHandler != null) {
            mDefaultCrashHandler!!.uncaughtException(thread, ex)
        } else {
            android.os.Process.killProcess(android.os.Process.myPid())
        }
        System.exit(0)

    }

    companion object {

        val instance by lazy {
            CrashHandler()
        }
    }
}