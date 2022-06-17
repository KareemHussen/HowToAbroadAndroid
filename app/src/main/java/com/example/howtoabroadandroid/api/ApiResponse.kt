package com.example.howtoabroadandroid.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiResponse {

   private val retrofit by lazy {
       Retrofit.Builder()
           .baseUrl("https://jsonplaceholder.typicode.com/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
   }

   val api : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}