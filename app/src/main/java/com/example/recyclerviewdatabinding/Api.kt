package com.example.recyclerviewdatabinding

import retrofit2.http.GET

interface Api {

    @GET("users")
    suspend fun getuser():List<Model>
}