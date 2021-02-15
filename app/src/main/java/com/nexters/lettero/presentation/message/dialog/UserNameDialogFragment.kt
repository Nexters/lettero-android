package com.nexters.lettero.presentation.message.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentUserNameDialogBinding
import com.nexters.lettero.presentation.message.viewmodel.UserNameDialogViewModel

class UserNameDialogFragment : DialogFragment() {

    val viewModel = UserNameDialogViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentUserNameDialogBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_user_name_dialog,
            container,
            false
        )
        binding.viewmodel = viewModel
        binding.view = this

        dialog?.window?.setBackgroundDrawable(resources.getDrawable(R.drawable.radius_11dp, null))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.get("isAnonymous")?.let {
            viewModel.setPrivate(it as Boolean)
        }
    }

    fun cancel(view: View) {
        dismiss()
    }

    fun complete(view: View) {
        findNavController().previousBackStackEntry?.apply {
            savedStateHandle.set<Boolean>("isAnonymous", viewModel.isPrivateName.value)
        }
        dismiss()
    }
}