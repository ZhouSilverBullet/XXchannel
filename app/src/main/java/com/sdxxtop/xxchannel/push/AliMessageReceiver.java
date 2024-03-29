package com.sdxxtop.xxchannel.push;

import android.content.Context;
import android.util.Log;

import com.alibaba.sdk.android.push.MessageReceiver;

/**
 * Created by Administrator on 2018/5/23.
 */

public class AliMessageReceiver extends MessageReceiver {

    @Override
    protected void onNotificationClickedWithNoAction(Context context, String title, String summary, String extraMap) {
        Log.e("MyMessageReceiver", "onNotificationClickedWithNoAction, title: " + title + ", summary: " + summary + ", extraMap:" + extraMap);
        handleClickData(context, title, summary, extraMap);
    }

    private void handleClickData(final Context context, String title, String summary, String extraMap) {

        PushCenterActivity.startActivityToReceiver(context, extraMap);

    }
}
