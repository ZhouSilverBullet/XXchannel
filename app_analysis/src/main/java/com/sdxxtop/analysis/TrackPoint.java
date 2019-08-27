package com.sdxxtop.analysis;

import com.sdxxtop.analysis.callback.TrackPointCallBack;
import com.sdxxtop.analysis.impl.TrackPointCallBackImpl;

public class TrackPoint {

    private static TrackPointCallBack trackPointCallBack;

    private TrackPoint() {
    }

    public static void init() {
        init(new TrackPointCallBackImpl());
    }

    public static void init(TrackPointCallBack callBack) {
        if (trackPointCallBack == null) {
            trackPointCallBack = callBack;
        }
    }

    static void onClick(String pageClassName, String viewIdName) {
        if (trackPointCallBack == null) {
            return;
        }
        trackPointCallBack.onClick(pageClassName, viewIdName);
    }

    static void onPageOpen(String pageClassName) {
        if (trackPointCallBack == null) {
            return;
        }
//        trackPointCallBack.onPageOpen(pageClassName);
    }

    static void onPageClose(String pageClassName) {
        if (trackPointCallBack == null) {
            return;
        }
//        trackPointCallBack.onPageClose(pageClassName);
    }
}
