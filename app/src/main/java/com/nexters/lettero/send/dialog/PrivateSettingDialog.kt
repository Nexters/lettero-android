package com.nexters.lettero.send.dialog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nexters.lettero.R
import com.nexters.lettero.databinding.DialogSendPrivateBinding

class PrivateSettingDialog : Activity() {
    private val privateSettingVm = PrivateSettingViewModel()
    private lateinit var bindingDialog: DialogSendPrivateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingDialog = DataBindingUtil.setContentView(this, R.layout.dialog_send_private)
        bindingDialog.vm = privateSettingVm
        init()
    }

    fun init() {
        bindingDialog.privateClose.setOnClickListener { finish() }
        bindingDialog.privateComplete.setOnClickListener {
            val intent = Intent()
            intent.putExtra("isPrivate", privateSettingVm.isPrivate.get())

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}