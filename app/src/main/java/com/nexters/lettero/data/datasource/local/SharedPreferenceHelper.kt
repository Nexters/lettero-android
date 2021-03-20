package com.nexters.lettero.data.datasource.local

import android.content.Context
import android.content.SharedPreferences
import com.nexters.lettero.R

class SharedPreferenceHelper(val context: Context) {
    val PREFERENCE_NAME = String.format("%s_preference", context.getString(R.string.app_name))
    private var _instance: SharedPreferences? = null

    private fun getSharedPreference(): SharedPreferences {
        if (_instance == null) {
            _instance = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        }

        return _instance as SharedPreferences
    }

    fun saveKeyValue(key: String, value: String) {
        getSharedPreference().edit().putString(key, value)
    }

    fun saveKeyValue(key: String, value: Boolean) {
        getSharedPreference().edit().putBoolean(key, value)
    }

    fun getStringValue(key: String): String? {
        return getSharedPreference().getString(key, "")
    }

    fun getBooleanValue(key: String, defValue: Boolean): Boolean {
        return getSharedPreference().getBoolean(key, defValue)
    }
}