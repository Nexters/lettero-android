package com.nexters.lettero.domain.repository

import com.nexters.lettero.data.datasource.remote.LetteroNetworkHelper
import com.nexters.lettero.data.datasource.remote.MessageService
import com.nexters.lettero.data.mapper.ReceiveMessageMapper
import com.nexters.lettero.data.mapper.SendMessageMapper
import com.nexters.lettero.data.model.SendMessageRequest
import com.nexters.lettero.data.model.SendMessageResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MessageRepository {
    private val msgService = LetteroNetworkHelper.getService(MessageService::class.java)

    fun getReceiveMessages() = msgService.findReceiveMessages()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun getSendMessages() = msgService.findSendMessages()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun sendMessage(msg: SendMessageRequest): Single<SendMessageResponse> =
        msgService.sendMessage(msg).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}