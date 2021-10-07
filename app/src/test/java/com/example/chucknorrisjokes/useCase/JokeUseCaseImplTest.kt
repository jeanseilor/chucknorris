package com.example.chucknorrisjokes.useCase


import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.maps.JokeEntityToDomainImpl
import com.example.chucknorrisjokes.repository.JokeRepositoryImpl
import com.example.chucknorrisjokes.service.entity.JokeEntity
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import java.lang.Exception

class JokeUseCaseImplTest {

    @Test
    fun `GIVEN the repository and map are mocked WHEN JokeUseCase is called THEM the getRandom is called once with values correctly`() =
        runBlocking {

            val jokeEntityMock = JokeEntity("value1")
            val jokeDomainMock = JokeDomain("value1")

            val jokeRepositoryImpl: JokeRepositoryImpl = mockk(relaxed = true)
            coEvery { jokeRepositoryImpl.getRandom() } returns jokeEntityMock

            val jokeEntityToDomainImpl: JokeEntityToDomainImpl = mockk(relaxed = true)
            every { jokeEntityToDomainImpl.toJokeDomain(jokeEntityMock) } returns jokeDomainMock

            val mockOnError = mockk<(throwable: Throwable) -> Unit>()

            every { mockOnError.invoke(any()) } returns Unit


            JokeUseCaseImpl(jokeRepositoryImpl, jokeEntityToDomainImpl).getRandom(
                onSuccess = {
                    Assert.assertEquals(it, jokeDomainMock)
                },
                onError = mockOnError
            )
            verify(exactly = 0) { mockOnError(any()) }


        }


    @Test
    fun `GIVEN the repository and map are mocked WHEN JokeUseCase is called THEM the getRandom is called once with error`() =
        runBlocking {

            val jokeEntityMock = JokeEntity("value1")
            val jokeRepositoryImpl: JokeRepositoryImpl = mockk(relaxed = true)
            coEvery { jokeRepositoryImpl.getRandom() } returns jokeEntityMock

            val jokeEntityToDomainImpl: JokeEntityToDomainImpl = mockk(relaxed = true)
            var error = Exception("Error")
            every { jokeEntityToDomainImpl.toJokeDomain(jokeEntityMock) }.throws(error)

            val mockOnSuccess = mockk<(jokeDomain: JokeDomain) -> Unit>()
            every { mockOnSuccess.invoke(any()) } returns Unit


            JokeUseCaseImpl(jokeRepositoryImpl, jokeEntityToDomainImpl).getRandom(
                onSuccess = mockOnSuccess,
                onError = {
                    Assert.assertEquals(it, error)
                }
            )
            verify(exactly = 0) { mockOnSuccess(any()) }


        }


}