package com.sdxxtop.common.model.helper;

import android.content.Context;
import android.text.TextUtils;

import com.sdxxtop.common.CommonSession;
import com.sdxxtop.common.utils.DeviceUtil;
import com.sdxxtop.common.utils.SpUtil;
import com.sdxxtop.common.utils.StringUtil;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/5/7.
 */

public class Params {
    protected Context context;
    protected HashMap<String, String> map;

    public Params() {
        map = new HashMap<>();
        context = CommonSession.getContext();
        defaultValue();
    }

    private void defaultValue() {
        put("ui", SpUtil.getInt(HttpConstantValue.USER_ID, 0));
        put("pi", SpUtil.getInt(HttpConstantValue.PART_ID, 0));
        put("plid", "1");
    }

    public String getUserId() {
        String ui = map.get("ui");
        if (TextUtils.isEmpty(ui)) {
            ui = String.valueOf(SpUtil.getInt(HttpConstantValue.USER_ID, 0));
        }
        return ui;
    }

    public String getPartId() {
        String pi = map.get("ci");
        if (TextUtils.isEmpty(pi)) {
            pi = String.valueOf(SpUtil.getInt(HttpConstantValue.PART_ID, 0));
        }
        return pi;
    }

    public void removeKey(String key) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
    }

    public void put(String key, String value) {
        map.put(key, StringUtil.stringNotNull(value));
    }

    public void put(String key, long value) {
        map.put(key, value + "");
    }

    public void put(String key, int value) {
        map.put(key, value + "");
    }

    public String getData() {
        return NetUtil.getBase64Data(map, CommonSession.INSTANCE.getVersion());
    }

    public void putDeviceNo() {
        map.put("dn", DeviceUtil.getDeviceNo(context));
    }
}
