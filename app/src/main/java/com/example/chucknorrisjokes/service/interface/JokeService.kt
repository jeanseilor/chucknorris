package com.example.chucknorrisjokes.service.`interface`


import com.example.chucknorrisjokes.service.entity.JokeEntity
import retrofit2.Call
import retrofit2.http.GET

interface JokeService {

    @GET("random")
    suspend fun getRandom(): JokeEntity
}