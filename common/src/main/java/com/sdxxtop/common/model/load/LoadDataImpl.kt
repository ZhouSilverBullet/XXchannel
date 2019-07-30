package com.sdxxtop.common.model.load

import android.content.Context
import com.sdxxtop.common.model.helper.data.BaseResponse
import com.sdxxtop.common.utils.NetworkUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.net.UnknownHostException

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-30 11:11
 * Version: 1.0
 * Description:
 */
class LoadDataImpl(override val context: Context, override val viewModelScope: CoroutineScope) : ILoadData {

    override fun <T> loadCatchOnUI(block: suspend CoroutineScope.() -> BaseResponse<T>,
                                   successBlock: (T) -> Unit,
                                   failBlock: (code: Int, msg: String, t: Throwable) -> Unit,
                                   catchBack: suspend CoroutineScope.(t: Throwable) -> Unit,
                                   finallyBack: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch {
            try {
                if (NetworkUtils.isNetworkAvailable(context)) {
                    converterResponse(block(), successBlock, failBlock)
                } else {
                    catchBack(UnknownHostException("网络连接失败，请重试"))
                }
            } catch (e: Exception) {
                catchBack(e)
            } finally {
                finallyBack()
            }
        }
    }

    override fun <T> loadOnUI(block: suspend CoroutineScope.() -> BaseResponse<T>,
                              successBlock: (T) -> Unit,
            //空实现带参方法
                              failBlock: (code: Int, msg: String, t: Throwable) -> Unit,
                              finallyBack: suspend CoroutineScope.() -> Unit

    ) {
        viewModelScope.launch {
            try {
                if (NetworkUtils.isNetworkAvailable(context)) {
                    converterResponse(block(), successBlock, failBlock)
                } else {
                    failBlock(-100, "网络连接失败，请重试", UnknownHostException())
                }
            } catch (e: Exception) {
                failBlock(-101, NetworkUtils.getHttpExceptionMsg(e), e)
            } finally {
                finallyBack()
            }
        }
    }

    /**
     * 转换
     * 成功 successBlock
     * 失败 failBlock
     */
    fun <T> converterResponse(response: BaseResponse<T>,
                              successBlock: (T) -> Unit
                              , failBlock: (code: Int, msg: String, t: Throwable) -> Unit) {
        if (response.code == 200) {
            successBlock(response.data)
        } else {
            failBlock(response.code, response.msg, Throwable("正常数据，业务code非200"))
        }
    }


    override fun <T> loadBaseOnUI(block: suspend CoroutineScope.() -> BaseResponse<T>,
                                  successBlock: (BaseResponse<T>) -> Unit,
                                  failBlock: (code: Int, msg: String, t: Throwable) -> Unit,
                                  finallyBack: suspend CoroutineScope.() -> Unit

    ) {
        viewModelScope.launch {
            try {
                if (NetworkUtils.isNetworkAvailable(context)) {
                    converterBaseResponse(block(), successBlock, failBlock)
                } else {
                    failBlock(-100, "网络连接失败", UnknownHostException())
                }
            } catch (e: Exception) {
                failBlock(-101, NetworkUtils.getHttpExceptionMsg(e), e)
            } finally {
                finallyBack()
            }
        }
    }

    /**
     * 转换base结果
     * 成功 successBlock
     * 失败 failBlock
     */
    fun <T> converterBaseResponse(response: BaseResponse<T>,
                                  successBlock: (BaseResponse<T>) -> Unit
                                  , failBlock: (code: Int, msg: String, t: Throwable) -> Unit) {
        if (response.code == 200) {
            successBlock(response)
        } else {
            failBlock(response.code, response.msg, Throwable("正常数据，业务code非200"))
        }
    }
}