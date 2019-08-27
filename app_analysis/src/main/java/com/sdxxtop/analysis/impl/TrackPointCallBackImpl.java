package com.sdxxtop.analysis.impl;

import android.util.Log;

import com.sdxxtop.analysis.callback.TrackPointCallBack;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-08-08 15:39
 * Version: 1.0
 * Description:
 */
public class TrackPointCallBackImpl implements TrackPointCallBack {
    private static final String TAG = "TrackPointCallBackImpl";

    @Override
    public void onClick(String pageClassName, String viewIdName) {
        Log.d(TAG, "onClick: " + pageClassName + "-" + viewIdName);
        //添加你的操作
    }

//    @Override
//    public void onPageOpen(String pageClassName) {
//        Log.d(TAG, "onPageOpen: " + pageClassName);
//        //添加你的操作
//    }
//
//    @Override
//    public void onPageClose(String pageClassName) {
//        Log.d(TAG, "onPageClose: " + pageClassName);
//        //添加你的操作
//    }
}
