package com.dw.hedge.retrofit

import com.dw.hedge.util.Content
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object RetrofitClient {


    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Content.ULR)
            .addConverterFactory(GsonConverterFactory.create()) // JSON 변환 설정
            .build()
            .create(ApiService::class.java)
    }
}