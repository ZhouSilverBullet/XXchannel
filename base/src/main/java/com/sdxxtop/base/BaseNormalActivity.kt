package com.sdxxtop.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Email: sdxxtop@163.com
 * Created by sdxxtop 2019-07-25 15:19
 * Version: 1.0
 * Description:
 */
abstract class BaseNormalActivity<DB : ViewDataBinding> : AppCompatActivity(), IView {
    companion object {
        const val TAG = "BaseActivity"
    }

    val mBinding: DB by lazy {
        setContentView<DB>(this, layoutId())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.lifecycleOwner = this
        mBinding.executePendingBindings()

        initView()
        initData()
        loadData()
    }

    override fun initData() {
    }

}