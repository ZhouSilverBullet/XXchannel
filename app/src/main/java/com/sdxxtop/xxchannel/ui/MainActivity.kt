package com.sdxxtop.xxchannel.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.permissions.RxPermissions
import com.sdxxtop.base.lifecycle.ActivityLifecycleImpl
import com.sdxxtop.common.dialog.download.DownloadDialog
import com.sdxxtop.crash.test.CrashTestActivity
import com.sdxxtop.mapsdk.MapTestActivity
import com.sdxxtop.ui.timerselect.BottomDialogView
import com.sdxxtop.xxchannel.R
import com.sdxxtop.xxchannel.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(ActivityLifecycleImpl(this))
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

    fun skipLogin(v: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun openAMap(v: View) {
        startActivity(Intent(this, MapTestActivity::class.java))
    }

    fun openCrash(v: View) {
        startActivity(Intent(this, CrashTestActivity::class.java))
    }

    val bottomDialogView by lazy {
        BottomDialogView(this)
    }

    fun openSelectPicker(v: View) {
        bottomDialogView.show()
    }

    fun openSelectPicture(v: View) {
        PictureSelector.create(this).openGallery(PictureMimeType.ofImage())
                .compress(true).selectionMode(PictureConfig.SINGLE)
                .maxSelectNum(1).forResult(10)
    }
}
