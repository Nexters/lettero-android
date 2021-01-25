package com.nexters.lettero.presentation.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentPostBoxBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.main.viewmodel.PostBoxViewModel

class PostBoxFragment : BaseFragment<FragmentPostBoxBinding, PostBoxViewModel>() {
    override val layoutRes: Int = R.layout.fragment_post_box
    override var viewModel: PostBoxViewModel = PostBoxViewModel()
}
