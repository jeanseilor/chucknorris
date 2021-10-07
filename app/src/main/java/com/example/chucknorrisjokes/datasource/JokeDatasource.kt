package com.example.chucknorrisjokes.datasource

import com.example.chucknorrisjokes.service.entity.JokeEntity


interface JokeDatasource {
    suspend fun getRandom(): JokeEntity
}