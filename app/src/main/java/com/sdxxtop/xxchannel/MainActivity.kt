package com.sdxxtop.xxchannel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.luck.picture.lib.permissions.RxPermissions
import com.sdxxtop.common.dialog.download.DownloadDialog

class MainActivity : AppCompatActivity() {
    val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObserve()
    }

    private fun initObserve() {
        //初始化的监听
        mainViewModel.mInitData.observe(this, Observer {
            var downloadDialog = DownloadDialog(this@MainActivity, it, R.mipmap.ic_launcher, RxPermissions(this@MainActivity))
            downloadDialog.show()
        })
    }

    fun updateApk(v: View) {
        //点击更新
        mainViewModel.loadData()
    }
}
