package com.example.chucknorrisjokes.repository

import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.entity.JokeEntity
import retrofit2.Call
import retrofit2.Response

interface JokeRepository {
    suspend fun getRandom(): Call<JokeEntity>
}