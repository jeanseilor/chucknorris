package com.example.chucknorrisjokes.datasource


import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.entity.JokeEntity


class JokeDatasourceImpl(private val JokeService: JokeService) : JokeDatasource {
    override suspend fun getRandom(): JokeEntity {
        return JokeService.getRandom()
    }
}