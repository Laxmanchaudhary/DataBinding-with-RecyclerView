package com.example.recyclerviewdatabinding

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {

    private val BASE_URL:String="https://jsonplaceholder.typicode.com/"
    var builder=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())

    fun <T>getAlluser(apiclass:Class<T>):T {
         return builder.build().create(apiclass)
    }
}