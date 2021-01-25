package com.nexters.lettero.presentation.main.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMainBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.main.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override val layoutRes: Int = R.layout.fragment_main
    override var viewModel: MainViewModel = MainViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            val navHost =
                childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

            bottomNavigationView.itemIconTintList = null
            bottomNavigationView.setupWithNavController(navHost.navController)
            bottomNavigationView.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.postbox -> it.onNavDestinationSelected(navHost.navController)
                    R.id.my_page -> it.onNavDestinationSelected(navHost.navController)
                    R.id.send_message -> {
                        navigateToSendMessageFragment(findNavController())
                        false
                    }
                    else -> true
                }
            }
        }
    }

    private fun navigateToSendMessageFragment(navController: NavController) {
        val action = MainFragmentDirections.actionMainFragmentToSendMessageFragment2()
        navController.navigate(action)
    }
}
