package com.example.chucknorrisjokes.datasource

import com.example.chucknorrisjokes.service.entity.JokeEntity
import retrofit2.Call

interface JokeDatasource {
    suspend fun getRandom(): JokeEntity
}