package com.example.chucknorrisjokes.maps

import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.service.entity.JokeEntity


interface JokeEntityToDomain {
    fun toJokeDomain(jokeEntity: JokeEntity): JokeDomain
}