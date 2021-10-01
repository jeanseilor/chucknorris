package com.example.chucknorrisjokes.useCase

import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.maps.JokeEntityToDomain
import com.example.chucknorrisjokes.repository.JokeRepository
import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.entity.JokeEntity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class JokeUseCaseImpl : JokeUseCase, KoinComponent {
    private val jokeRepository: JokeRepository by inject()

    override suspend fun getRandom(): JokeDomain {
        try {
            val request = jokeRepository.getRandom().execute()
            if (request.isSuccessful) {
                val jokeEntityValue = request.body() as JokeEntity

                return JokeEntityToDomain.toJokeDomain(jokeEntityValue)
            }
            throw Exception("Error")
        } catch (e: Exception) {
            throw e
        }
    }
}