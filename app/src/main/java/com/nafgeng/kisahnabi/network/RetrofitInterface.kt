package com.nafgeng.kisahnabi.network

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("v1/nabi")
    fun getDataNabi() : Call<List<ResponseNabiItem>>

    @GET("v1/Rasul")
    fun getDataRasul() : Call<List<ResponseNabiItem>>
}