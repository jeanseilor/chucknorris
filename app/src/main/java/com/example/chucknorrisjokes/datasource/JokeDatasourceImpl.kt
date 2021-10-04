package com.example.chucknorrisjokes.datasource


import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.entity.JokeEntity
import retrofit2.Call

class JokeDatasourceImpl(private val JokeService: JokeService) : JokeDatasource {
    override suspend fun getRandom(): Call<JokeEntity> {
        return JokeService.getRandom()
    }
}