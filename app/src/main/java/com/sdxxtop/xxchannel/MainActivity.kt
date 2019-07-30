package com.sdxxtop.xxchannel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orhanobut.logger.Logger
import com.sdxxtop.common.model.helper.Params
import com.sdxxtop.xxchannel.model.api.RetrofitClient
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var mainScope = MainScope()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainScope.launch {
            val param = Params()
            val postAppInit = RetrofitClient.apiService.postAppInit(param.data)
            Logger.i(postAppInit.toString())
        }
    }
}
