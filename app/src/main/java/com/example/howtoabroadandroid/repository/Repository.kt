package com.example.howtoabroadandroid.repository


import com.example.howtoabroadandroid.api.ApiResponse
import retrofit2.Response
import kotlin.math.abs

class Repository {

       suspend fun getAllPosts() = ApiResponse.api.getAllPosts()

}