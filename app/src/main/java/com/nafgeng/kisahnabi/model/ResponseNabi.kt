package com.nafgeng.kisahnabi.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseNabiItem(

    @field:SerializedName("usia")
    val usia: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("tempat")
    val tempat: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("deskripsi")
    val deskripsi: String? = null,

    @field:SerializedName("avatar")
    val avatar: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("tp_kelahiran")
    val tpKelahiran: String? = null
) : Parcelable