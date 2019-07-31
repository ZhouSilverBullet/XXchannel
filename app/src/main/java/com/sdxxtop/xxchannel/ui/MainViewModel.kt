package com.sdxxtop.xxchannel.ui

import androidx.lifecycle.MediatorLiveData
import com.sdxxtop.base.BaseViewModel
import com.sdxxtop.network.helper.Params
import com.sdxxtop.xxchannel.App
import com.sdxxtop.xxchannel.model.api.RetrofitClient
import com.sdxxtop.xxchannel.model.data.InitData
import es.dmoral.toasty.Toasty

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-30 09:45
 * Version: 1.0
 * Description:
 */
class MainViewModel : BaseViewModel() {
    val mInitData  = MediatorLiveData<InitData>()

    fun loadData() {
        loadOnUI({
            val param = Params()
            param.put("ui", "50172")
            param.put("pi", "1")
            //这里实际上返回了结果
            RetrofitClient.apiService.postAppInit(param.data)
        }, {
//            Logger.e(it.toString())
            mInitData.value = it
        }, { code, msg, t ->
            Toasty.error(App.INSTANCE, msg).show()
        })
    }

}