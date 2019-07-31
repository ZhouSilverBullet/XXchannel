package com.sdxxtop.xxchannel.ui.login

import android.graphics.Color
import android.text.*
import android.text.style.ForegroundColorSpan
import android.view.View
import com.sdxxtop.base.BaseActivity
import com.sdxxtop.common.utils.PhoneTextWatcher
import com.sdxxtop.xxchannel.R
import com.sdxxtop.xxchannel.databinding.ActivityLoginBinding
import com.sdxxtop.xxchannel.ui.login.viewmodel.LoginViewModel
import com.sdxxtop.xxchannel.ui.servicecontract.ServiceContractActivity

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun vmClazz() = LoginViewModel::class.java

    override fun bindVM() {
        mBinding.vm = mViewModel
    }

    override fun initObserve() {

    }

    override fun layoutId() = R.layout.activity_login

    override fun initView() {
        //设置手机号格式
        mBinding.etPhonenum.addTextChangedListener(PhoneTextWatcher(mBinding.etPhonenum, mBinding.ivDelPhone, mBinding.etPwd))
        //设置EditText长度限制
        mBinding.etPhonenum.setFilters(arrayOf<InputFilter>(InputFilter.LengthFilter(13)))
        mBinding.etPwd.setFilters(arrayOf<InputFilter>(InputFilter.LengthFilter(16)))

        setTvContract()
    }

    private fun setTvContract() {
        val value = "登录即表示您已同意《知点云服务协议》"
        val builder = SpannableStringBuilder(value)
        val blackSpan = ForegroundColorSpan(Color.parseColor("#666666"))
        builder.setSpan(blackSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        val blueSpan = ForegroundColorSpan(Color.parseColor("#3296FA"))
        builder.setSpan(blueSpan, 9, value.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        mBinding.tvContract.setText(builder)

        mBinding.tvContract.setOnClickListener { v ->
            ServiceContractActivity.skipServiceContract(v.context)
        }
    }

    override fun initEvent() {
        mBinding.etPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (TextUtils.isEmpty(s)) {
                    mBinding.ivDelPwd.visibility = View.GONE
                } else {
                    if (mBinding.etPwd.isFocused) {
                        mBinding.ivDelPwd.visibility = View.VISIBLE
                    }
                }
            }
        })

        mBinding.etPwd.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus && !TextUtils.isEmpty(mBinding.etPwd.getText().toString())) {
                mBinding.ivDelPwd.visibility = View.VISIBLE
            } else {
                mBinding.ivDelPwd.visibility = View.GONE
            }
        }

        mBinding.etPhonenum.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus && !TextUtils.isEmpty(mBinding.etPhonenum.getText().toString())) {
                mBinding.ivDelPhone.visibility = View.VISIBLE
            } else {
                mBinding.ivDelPhone.visibility = View.GONE
            }
        }

        mBinding.cbEye.setOnCheckedChangeListener { buttonView, isChecked ->
            val passwordLength = mBinding.etPwd.text.length
            mBinding.etPwd.inputType = if (isChecked)
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            else
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            mBinding.etPwd.setSelection(passwordLength)
        }
    }
}
