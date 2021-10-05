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
            onSuccess(jokeEntityToDomain.toJokeDomain(jokeRepository.getRandom()))
        } catch (e: Exception) {
            onError(e)
        }
    }


}