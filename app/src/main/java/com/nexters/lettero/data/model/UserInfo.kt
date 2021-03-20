package com.nexters.lettero.data.model

import com.google.firebase.auth.FirebaseUser

class UserInfo private constructor() {
    var user: User? = null
    var accessToken:String? = null
    var refershToken:String? = null
    var firebaseInfo: FirebaseUser? = null

    companion object {
        @Volatile private var instance: UserInfo? = null

        @JvmStatic fun getInstance(): UserInfo =
            instance ?: synchronized(this) {
                instance ?: UserInfo().also {
                    instance = it
            }
        }
    }
}