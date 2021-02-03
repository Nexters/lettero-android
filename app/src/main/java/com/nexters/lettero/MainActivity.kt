package com.nexters.lettero

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.nexters.lettero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(
                    MainActivity::class.qualifiedName,
                    "Fetching FCM registration token failed",
                    task.exception
                )
                return@OnCompleteListener
            }
        })

        setFragment()
    }

    fun setFragment() {
        // replaceFragment(initFragment) // 초기화할 fragment 명시
        binding.menuMsgBox.setOnClickListener {  }
        binding.menuWrite.setOnClickListener {  }
        binding.menuMypage.setOnClickListener {  }
    }

    // 버튼 클릭 시, 교체할 fragment 명시하여 컨테이너 변경
    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.lettero_fragment_container, fragment)
        fragmentTransaction.commit()
    }
}