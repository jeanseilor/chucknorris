package com.example.chucknorrisjokes.useCase

import com.example.chucknorrisjokes.domain.JokeDomain

interface JokeUseCase {
    suspend fun getRandom(onError:(Throwable)-> Unit, onSuccess:(JokeDomain)->Unit)
}