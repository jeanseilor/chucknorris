package com.example.chucknorrisjokes.maps


import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.service.entity.JokeEntity


class JokeEntityToDomainImpl() : JokeEntityToDomain {
    override fun toJokeDomain(jokeEntity: JokeEntity): JokeDomain {
        return JokeDomain(jokeEntity.value)
    }
}