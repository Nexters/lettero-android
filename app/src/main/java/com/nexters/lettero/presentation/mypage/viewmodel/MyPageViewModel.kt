package com.nexters.lettero.presentation.mypage.viewmodel

import androidx.databinding.ObservableField
import com.nexters.lettero.presentation.base.ViewModel

class MyPageViewModel : ViewModel {

    val name = ObservableField<String>()
    val phoneNumber = ObservableField<String>()

    init {
        //TODO : 사용자 정보 연동 후 변경 예정
        name.set("aaa")
        phoneNumber.set("010-0000-0000")
    }
}
