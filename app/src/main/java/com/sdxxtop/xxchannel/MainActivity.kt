package com.sdxxtop.xxchannel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import com.sdxxtop.common.model.helper.Params
import com.sdxxtop.xxchannel.model.api.RetrofitClient
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainViewModel().loadData()
    }
}
