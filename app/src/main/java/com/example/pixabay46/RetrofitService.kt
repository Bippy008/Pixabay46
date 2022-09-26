package com.example.pixabay46

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitService {
    private val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/").
            addConverterFactory(GsonConverterFactory.create()).build()

    fun getApi() = retrofit.create(PixaApi::class.java)
}