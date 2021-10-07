package com.example.chucknorrisjokes.maps


import com.example.chucknorrisjokes.service.entity.JokeEntity

import com.example.chucknorrisjokes.domain.JokeDomain


interface JokeEntityToDomain {
    fun toJokeDomain(jokeEntity: JokeEntity): JokeDomain
}