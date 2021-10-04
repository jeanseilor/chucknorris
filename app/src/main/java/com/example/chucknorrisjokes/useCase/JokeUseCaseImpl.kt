package com.example.chucknorrisjokes.useCase

import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.maps.JokeEntityToDomain
import com.example.chucknorrisjokes.repository.JokeRepository
import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.entity.JokeEntity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class JokeUseCaseImpl(private val jokeRepository: JokeRepository) : JokeUseCase {

    override suspend fun getRandom(
        onError: (Throwable) -> Unit,
        onSuccess: (JokeDomain) -> Unit
    ) {
        try {
            onSuccess(JokeEntityToDomain.toJokeDomain(jokeRepository.getRandom()))
        } catch (e: Exception) {
            onError(e)
        }
    }


}