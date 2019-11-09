package com.sdxxtop.xxchannel.model.helper

import com.sdxxtop.network.helper.HttpConstantValue
import com.sdxxtop.network.helper.base.BaseImageParams
import com.sdxxtop.network.helper.base.BaseParams
import com.sdxxtop.network.utils.SpUtil

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-09-19 14:33
 * Version: 1.0
 * Description:
 */
class HttpImageParams : BaseImageParams() {

    override fun defaultValue() {
        put("ui", SpUtil.getInt(HttpConstantValue.USER_ID, 0))
        put("pti", SpUtil.getInt(HttpConstantValue.PART_ID, 0))
        put("pi", HttpConstantValue.PLATFORM_ID)
    }

}