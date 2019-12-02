package com.sdxxtop.xxchannel.model.api

import com.sdxxtop.network.helper.data.BaseResponse
import okhttp3.RequestBody
import retrofit2.http.*

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-29 20:21
 * Version: 1.0
 * Description:
 */

interface GoService {
    companion object {
        const val BASE_URL = "http://192.168.1.229:8080/"
    }

    @Multipart
    @POST("car")
    suspend fun postCarInfo(@PartMap map: Map<String, @JvmSuppressWildcards RequestBody>): BaseResponse<Any>
}