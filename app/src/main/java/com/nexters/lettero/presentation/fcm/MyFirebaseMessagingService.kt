package com.nexters.lettero.presentation.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.JsonObject
import com.nexters.lettero.R
import com.nexters.lettero.data.model.UserInfo
import com.nexters.lettero.domain.repository.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {
    @Inject
    lateinit var userRepository: UserRepository

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        Log.i("FirebaseCloudMessaging", token)
        saveFirebaseToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        notification(remoteMessage)
    }

    private fun notification(remoteMessage: RemoteMessage) {
        val channelId = packageName
        val notificationId = 0

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "lettero"
            val channelDescription = "alarm notification channel for lettero"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        var builder = NotificationCompat.Builder(this@MyFirebaseMessagingService, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(remoteMessage.notification?.title)
            .setContentText(remoteMessage.notification?.body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this@MyFirebaseMessagingService)) {
            notify(notificationId, builder.build())
        }
    }

    private fun saveFirebaseToken(token: String) {
        val json = JsonObject()
        json.addProperty("firebaseToken", token)

        userRepository.saveFirebaseToken(json).subscribe({ user ->
            UserInfo.getInstance().user = user
        }, { err ->
            android.util.Log.d("firebase save token error", err.message.toString())
        }).dispose()
    }
}
