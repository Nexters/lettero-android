package com.nexters.lettero.send

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import com.nexters.lettero.R
import com.nexters.lettero.databinding.ActivitySendBinding
import com.nexters.lettero.send.dialog.PrivateSettingDialog
import com.nexters.lettero.util.LetteroConstant

class SendActivity : AppCompatActivity() {
    private lateinit var sendViewModel: SendViewModel
    private lateinit var bindingUtil: ActivitySendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUtil =
            DataBindingUtil.setContentView(this, R.layout.activity_send)

        sendViewModel = SendViewModel(this)
        bindingUtil.viewmodel = sendViewModel

        initLayout()
    }

    fun initLayout() {
        bindingUtil.sendMessageEdittext.doAfterTextChanged { text ->
            text?.toString()?.length?.let { sendViewModel.setMessageCnt(it) }
        }

        bindingUtil.sendClose.setOnClickListener { finish() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            LetteroConstant.REQ_PRIVATE_DIALOG -> {
                if(resultCode.equals(Activity.RESULT_OK)) {
                    data?.hasExtra("isPrivate")?.let {
                        sendViewModel.setSenderName(data.extras?.get("isPrivate") as Boolean)

                    }
                }
            }
        }
    }

    fun startPrivateDialog() {
        startActivityForResult(
            Intent(applicationContext, PrivateSettingDialog::class.java),
            LetteroConstant.REQ_PRIVATE_DIALOG
        )
    }

}