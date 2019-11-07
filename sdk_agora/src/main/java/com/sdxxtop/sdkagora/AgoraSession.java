package com.sdxxtop.sdkagora;

import android.app.Application;

import com.sdxxtop.openlive.AgoraAppLiveConfig;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-07 19:32
 * Version: 1.0
 * Description:
 */
public class AgoraSession {
    private static AgoraAppLiveConfig liveConfig;

    public static void init(Application application) {
        if (liveConfig == null) {
            liveConfig = new AgoraAppLiveConfig();
        }

        liveConfig.setApplication(application);
        liveConfig.onCreate();
    }

    public static void onTerminate() {
        getLiveConfig().onTerminate();
    }

    public static AgoraAppLiveConfig getLiveConfig() {
        return liveConfig;
    }
}
