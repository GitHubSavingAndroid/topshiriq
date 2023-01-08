package com.example.topshiriq

import retrofit2.http.GET

 interface NetworkApi {
    @GET("/posts")
    fun getPost():retrofit2.Call<List<post>>
}