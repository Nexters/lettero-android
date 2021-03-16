package com.nexters.lettero.data.datasource.remote

import com.nexters.lettero.data.model.SendMessageRequest
import com.nexters.lettero.data.model.SendMessageResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface MessageService {

    @POST("/api/message")
    fun sendMessage(@Body msgObject: SendMessageRequest): Single<SendMessageResponse>
}