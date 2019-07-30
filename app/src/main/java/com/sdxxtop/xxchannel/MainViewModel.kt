package com.sdxxtop.xxchannel

import com.orhanobut.logger.Logger
import com.sdxxtop.base.BaseViewModel
import com.sdxxtop.network.helper.Params
import com.sdxxtop.xxchannel.model.api.RetrofitClient
import es.dmoral.toasty.Toasty

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-30 09:45
 * Version: 1.0
 * Description:
 */
class MainViewModel : BaseViewModel() {
    fun loadData() {
        loadOnUI({
            val param = Params()
            //这里实际上返回了结果
            RetrofitClient.apiService.postAppInit(param.data)
        }, {
            Logger.e(it.toString())
        }, { code, msg, t ->
            Toasty.error(App.INSTANCE, msg).show()
        })
    }

}