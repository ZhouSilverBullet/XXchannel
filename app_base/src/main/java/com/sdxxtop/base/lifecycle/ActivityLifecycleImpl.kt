package com.sdxxtop.base.lifecycle

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.sdxxtop.sdk.AnalyticsHome

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-08-01 09:15
 * Version: 1.0
 * Description:
 */

class ActivityLifecycleImpl(val context: Context) : LifecycleObserver {
    private val TAG = ActivityLifecycleImpl::class.java.getSimpleName()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d(TAG, "onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d(TAG, "onStart")
    }

    /**
     * umeng 分析
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d(TAG, "onResume")
        AnalyticsHome.onActivityResume(context)
    }

    /**
     * umeng 分析
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d(TAG, "onPause")
        AnalyticsHome.onActivityPause(context)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(TAG, "onDestroy")
    }


}