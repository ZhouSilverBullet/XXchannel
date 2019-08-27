package com.sdxxtop.analysis.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.sdxxtop.analysis.adapter.ActivityLifecycleCallbackAdapter;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-08-07 10:47
 * Version: 1.0
 * Description:
 */
public class ActivityLifecycleListener extends ActivityLifecycleCallbackAdapter {
    private static final String TAG = "ActivityLifecycle";

    //时间总共的统计
    private Map<Context, Long> durationMap = new WeakHashMap<>();
    //活动的时长
    private Map<Context, Long> resumeTimeMap = new WeakHashMap<>();

    private Map<Context, FragmentLifecycleListener> listenerMap = new WeakHashMap<>();


    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        durationMap.put(activity, 0L);
        registerFragmentLifecycleListener(activity);
        Log.e(TAG, "onActivityCreated: ");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        resumeTimeMap.put(activity, System.currentTimeMillis());
        Log.e(TAG, "onActivityResumed: ");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.e(TAG, "onActivityPaused: ");
        try {
            durationMap.put(activity, durationMap.get(activity)
                    + (System.currentTimeMillis() - resumeTimeMap.get(activity)));
        } catch (Exception e) {
        }
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e(TAG, "onActivityDestroyed: ");
        long duration = durationMap.get(activity);
        if (duration > 0) {
            // 将事件添加到数据库
        }
        resumeTimeMap.remove(activity);
        durationMap.remove(activity);
    }


    private void registerFragmentLifecycleListener(final Activity context) {
        if (context instanceof FragmentActivity) {
            FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
            FragmentLifecycleListener listener = new FragmentLifecycleListener();
            listenerMap.put(context, listener);
            fm.registerFragmentLifecycleCallbacks(listener, true);
        }
    }

    private void unregisterFragmentLifecycleListener(final Activity context) {
        FragmentLifecycleListener listener = listenerMap.get(context);
        if (listener != null) {
            ((FragmentActivity)context).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(listener);
            listenerMap.remove(context);
        }
    }
}