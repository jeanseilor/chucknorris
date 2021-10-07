package com.example.chucknorrisjokes.repository

import com.example.chucknorrisjokes.application.AppDI
import com.example.chucknorrisjokes.application.NetworkModule
import com.example.chucknorrisjokes.datasource.JokeDatasource
import com.example.chucknorrisjokes.datasource.JokeDatasourceImpl
import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.entity.JokeEntity
import io.mockk.*


import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before

import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import retrofit2.Call

import retrofit2.Response


class JokeRepositoryImplTest {



    @Test
    fun `GIVEN the datasource is mocked when JokeDatasourceImpl is called THEM the getRandom is called once`() =
        runBlocking {
            val jokeEntityMock = JokeEntity("value1")

            val jokeService: JokeService = mockk(relaxed = true)
            coEvery { jokeService.getRandom() } returns jokeEntityMock

            val jokeDataSourceImpl = JokeDatasourceImpl(jokeService)
            val result = jokeDataSourceImpl.getRandom()

            coVerify(exactly = 1) { jokeService.getRandom() }
            Assert.assertEquals(jokeEntityMock, result)
        }
}
