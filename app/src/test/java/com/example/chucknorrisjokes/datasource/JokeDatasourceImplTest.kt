package com.example.chucknorrisjokes.datasource

import com.example.chucknorrisjokes.repository.JokeRepositoryImpl
import com.example.chucknorrisjokes.service.entity.JokeEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class JokeDatasourceImplTest {
    @Test
    fun `GIVEN the JokeService is mocked WHEN JokeRepository is called THEM the getRandom is called once`() = runBlocking {
        //GIVEN
        val jokeEntityMock = JokeEntity("value1")

        val jokeDatasource: JokeDatasource = mockk(relaxed = true)
        coEvery { jokeDatasource.getRandom() } returns jokeEntityMock

        val jokeRepositoryImpl = JokeRepositoryImpl(jokeDatasource)
        //WHEN
        val result = jokeRepositoryImpl.getRandom()
        //THEN
        coVerify(exactly = 1) { jokeDatasource.getRandom() }
        Assert.assertEquals(jokeEntityMock, result)
    }


}