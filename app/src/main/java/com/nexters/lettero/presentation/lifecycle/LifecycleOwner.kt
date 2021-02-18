package com.nexters.lettero.presentation.lifecycle

import androidx.lifecycle.Lifecycle

class LifecycleOwner {
    private val callbacks = mutableListOf<LifecycleCallback>()
    private var lastEvent = Lifecycle.Event.ON_CREATE

    fun register(callback: LifecycleCallback) {
        callback.apply(lastEvent)
        callbacks.add(callback)
    }

    fun unregister(callback: LifecycleCallback) {
        callbacks.remove(callback)
    }

    fun notifyEvent(event: Lifecycle.Event) {
        callbacks.forEach { it.apply(event) }
    }
}
