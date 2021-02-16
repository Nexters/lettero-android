package com.nexters.lettero.presentation.intro.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentIntroBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.intro.viewmodel.IntroViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainViewModel

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroViewModel>() {
    override val layoutRes: Int = R.layout.fragment_intro
    override var viewModel: ViewModel = MainViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TEST", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast

            Log.d("TEST", "result : " + token)
        })
    }
}