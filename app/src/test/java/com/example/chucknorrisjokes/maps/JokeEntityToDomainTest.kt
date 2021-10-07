package com.example.chucknorrisjokes.maps


import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.service.entity.JokeEntity

import org.junit.Assert.assertEquals
import org.junit.Test

class JokeEntityToDomainTest {

    @Test
    fun convertJokeEntityToDomain() {
        assertEquals(
            JokeDomain("value1"),
            JokeEntityToDomainImpl()
                .toJokeDomain(JokeEntity("value1"))
        )
    }

}