package com.example.chucknorrisjokes.useCase

import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.maps.JokeEntityToDomain
import com.example.chucknorrisjokes.repository.JokeRepository



class JokeUseCaseImpl(
    private val jokeRepository: JokeRepository,
    private val jokeEntityToDomain: JokeEntityToDomain
) : JokeUseCase {

    override suspend fun getRandom(
        onError: (Throwable) -> Unit,
        onSuccess: (JokeDomain) -> Unit
    ) {
        try {
            val result = jokeEntityToDomain.toJokeDomain(jokeRepository.getRandom())
            onSuccess(result)
        } catch (e: Exception) {
            onError(e)
        }
    }


}