package com.example.chucknorrisjokes.repository

import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.entity.JokeEntity
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class JokeRepositoryImpl(private var jokeService: JokeService) : JokeRepository {
    override suspend fun getRandom(): Call<JokeEntity> {
        return jokeService.getRandom()
    }
}