package com.nexters.lettero.data.datasource.remote

import com.nexters.lettero.data.model.ReceiveMessage
import com.nexters.lettero.data.model.SendMessage
import com.nexters.lettero.data.model.SendMessageRequest
import com.nexters.lettero.data.model.SendMessageResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MessageService {

    @GET("/api/receive-messages")
    fun findReceiveMessages(): Single<List<ReceiveMessage>>

    @GET("/api/send-messages")
    fun findSendMessages(): Single<List<SendMessage>>

    @POST("/api/message")
    fun sendMessage(@Body msgObject: SendMessageRequest): Single<SendMessageResponse>
}