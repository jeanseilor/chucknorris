package com.example.chucknorrisjokes.repository

import com.example.chucknorrisjokes.datasource.JokeDatasource
import com.example.chucknorrisjokes.service.entity.JokeEntity
import io.mockk.*


import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before

import org.junit.Test
import retrofit2.Call

import retrofit2.Response


class JokeRepositoryImplTest {


    @Test
    fun `should called the getRandom`() = runBlocking {


        val jokeDatasource = mockk<JokeDatasource>(relaxed = true)
        coEvery { jokeDatasource.getRandom() } returns call
        val expectedGetRandom = jokeRepository.getRandom().execute()
        coVerify(exactly = 1) { jokeRepository.getRandom() }

        Assert.assertEquals(expectedGetRandom, call)

    }


    @Test
    fun `should called the getRandom1`() = runBlocking {
        //GIVEN
        val jokeEntityMock = JokeEntity().also { it.value = "value1" }
//        every { call.execute() } returns Response.success(JokeEntity().also { it.value = "value1" })

        val jokeDatasource:JokeDatasource = mockk(relaxed = true)
//        coEvery { jokeDatasource.getRandom() } returns call

        val jokeRepositoryImpl  = JokeRepositoryImpl(jokeDatasource)
        //WHEN
        val result = jokeRepositoryImpl.getRandom()
        //THEN
        coVerify(exactly = 1){jokeDatasource.getRandom()}
        Assert.assertEquals(result, jokeEntityMock)
    }
}
