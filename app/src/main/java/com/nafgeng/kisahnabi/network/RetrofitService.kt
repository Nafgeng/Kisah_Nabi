package com.nafgeng.kisahnabi.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val client : OkHttpClient = OkHttpClient.Builder()
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://628d82f7368687f3e7048c1b.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(RetrofitInterface::class.java)
}