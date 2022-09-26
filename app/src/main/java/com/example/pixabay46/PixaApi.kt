package com.example.pixabay46

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {
    @GET("api/")
    fun getImages(
        @Query("key")key:String = "30185502-7c1ba58b6d1805bdb850ab7f4",
        @Query("q")keyWord:String,
        @Query("page") page:Int,
        @Query("per_page") perPage: Int = 10
    ): Call<PixaModel>
}