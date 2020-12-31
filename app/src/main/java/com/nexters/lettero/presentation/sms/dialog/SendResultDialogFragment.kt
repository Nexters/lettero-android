package com.nexters.lettero.presentation.sms.dialog

import android.os.Bundle
import android.view.View
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentSendResultDialogBinding
import com.nexters.lettero.presentation.base.BaseFragmentDialog
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.sms.viewmodel.SendResultViewModel

class SendResultDialogFragment : BaseFragmentDialog<FragmentSendResultDialogBinding, SendResultViewModel>() {
    override val layoutRes: Int = R.layout.fragment_send_result_dialog
    override var viewModel: ViewModel = SendResultViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.view = this
    }

    fun closeDialog(view: View) {
        dismiss()
    }
}