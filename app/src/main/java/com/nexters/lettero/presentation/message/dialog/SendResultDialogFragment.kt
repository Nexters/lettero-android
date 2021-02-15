package com.nexters.lettero.presentation.message.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentSendResultDialogBinding

class SendResultDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSendResultDialogBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_send_result_dialog,
            container,
            false
        )
        binding.view = this

        dialog?.window?.setBackgroundDrawable(resources.getDrawable(R.drawable.radius_11dp, null))

        return binding.root
    }

    fun closeDialog(view: View) {
        dismiss()
    }
}