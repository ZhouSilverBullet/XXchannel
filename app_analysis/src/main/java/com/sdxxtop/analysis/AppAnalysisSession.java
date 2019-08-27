package com.sdxxtop.analysis;

import android.app.Application;
import android.content.Context;

import com.sdxxtop.analysis.impl.ActivityLifecycleListener;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-08-08 15:43
 * Version: 1.0
 * Description:
 */
public class AppAnalysisSession {

    private Application mContext;

    private AppAnalysisSession() {
    }

    public static AppAnalysisSession getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final AppAnalysisSession INSTANCE = new AppAnalysisSession();
    }

    public void initAnalysis(Application context) {
        mContext = context;

        registerCallback(context);
    }

    private void registerCallback(Application context) {
        context.registerActivityLifecycleCallbacks(new ActivityLifecycleListener());
    }
}
