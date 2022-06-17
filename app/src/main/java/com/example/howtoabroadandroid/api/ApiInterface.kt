package com.example.howtoabroadandroid.api

import com.example.howtoabroadandroid.model.PostModel
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

   @GET("posts")
   suspend fun getAllPosts() : Response<PostModel>

}