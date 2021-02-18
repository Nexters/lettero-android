package com.nexters.lettero.presentation.lifecycle

import androidx.lifecycle.Lifecycle

interface LifecycleCallback {
    fun apply(event: Lifecycle.Event)
}
