package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*

interface Apiservice {
    @GET("1")
    fun callapi() : Call<DataItems>

    @GET("3")
    fun callapi2() : Call<DataItems>


    @GET("10")
    fun callapi3() : Call<DataItems>



}