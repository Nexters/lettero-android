package com.nexters.lettero.data.datasource.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object LetteroNetworkHelper {
    private const val BASE_URL = "http://ec2-3-19-215-20.us-east-2.compute.amazonaws.com/"
    private var retrofitService: Retrofit? = null

    fun<T> getService(service: Class<T>):T {
        if(retrofitService == null) {
            val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "DUMMY_TOKEN1") //TODO : 추후 변경 예정
                    .build()

                chain.proceed(newRequest)
            }.build()
        }

        return retrofitService!!.create(service)
    }
}
