package com.nexters.lettero.presentation.sms.dialog

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentUserNameDialogBinding
import com.nexters.lettero.presentation.base.BaseFragmentDialog
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.sms.viewmodel.UserNameDialogViewModel

class UserNameDialogFragment :
    BaseFragmentDialog<FragmentUserNameDialogBinding, UserNameDialogViewModel>() {
    override val layoutRes: Int = R.layout.fragment_user_name_dialog
    override var viewModel: ViewModel = UserNameDialogViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = viewModel as UserNameDialogViewModel
        binding.view = this

        arguments?.get("isAnonymous")?.let {
            (viewModel as UserNameDialogViewModel).setPrivate(it as Boolean)
        }
    }

    fun cancel(view: View) {
        dismiss()
    }

    fun complete(view: View) {
        findNavController().previousBackStackEntry?.apply {
            savedStateHandle.set<Boolean>(
                "isAnonymous",
                (viewModel as UserNameDialogViewModel).isPrivateName.value
            )
        }
        dismiss()
    }
}