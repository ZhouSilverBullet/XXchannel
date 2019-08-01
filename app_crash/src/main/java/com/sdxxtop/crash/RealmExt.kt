package com.sdxxtop.crash

import com.sdxxtop.common.GSON
import io.realm.RealmResults

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-08-01 17:04
 * Version: 1.0
 * Description:
 */
fun <T> RealmResults<T>.toJson() = GSON.toJson(this)