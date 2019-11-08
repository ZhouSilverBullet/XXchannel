package com.sdxxtop.xxchannel.model.api

import com.sdxxtop.common.dialog.download.data.InitData
import com.sdxxtop.network.helper.data.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-29 20:21
 * Version: 1.0
 * Description:
 */

interface ApiService {
    companion object {
        const val BASE_URL = "http://envir.sdxxtop.com/api/"
    }

    @FormUrlEncoded
    @POST("app/init")
    suspend fun postAppInit(@Field("data") data: String): BaseResponse<InitData>
}