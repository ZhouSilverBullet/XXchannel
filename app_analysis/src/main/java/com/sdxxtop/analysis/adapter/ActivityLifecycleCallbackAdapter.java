package com.sdxxtop.analysis.adapter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-08-07 10:48
 * Version: 1.0
 * Description:
 */
public abstract class ActivityLifecycleCallbackAdapter implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
