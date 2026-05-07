package com.mastercoding.movizapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Object: Defines a singleton, initialized once
object RetrofitInstance {

    private const val BASE_URL =
        "https://api.themoviedb.org/3/"


    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

}