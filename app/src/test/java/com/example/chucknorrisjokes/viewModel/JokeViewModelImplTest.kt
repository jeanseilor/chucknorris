package com.example.chucknorrisjokes.viewModel

import android.app.Application
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.maps.JokeEntityToDomainImpl
import com.example.chucknorrisjokes.service.entity.JokeEntity
import com.example.chucknorrisjokes.useCase.JokeUseCase
import com.example.chucknorrisjokes.useCase.JokeUseCaseImpl
import io.mockk.*
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import java.lang.Exception


@ExperimentalCoroutinesApi
class JokeViewModelImplTest {
    val dispatcher = TestCoroutineDispatcher()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `GIVEN the useCase is mocked WHEN JokeViewModel is called THEM the getRandom is called once with success`() =
        dispatcher.runBlockingTest {

            val contextMock: Application = mockk(relaxed = true)
            val jokeMockDomain = JokeDomain("value1")

            val jokeUseCaseImpl: JokeUseCaseImpl = mockk(relaxed = true)

            val onSuccessMock = slot<(JokeDomain) -> Unit>()
            val viewModel = JokeViewModelImpl(contextMock, jokeUseCaseImpl)

            coEvery {
                jokeUseCaseImpl.getRandom(
                    any(),
                    capture(onSuccessMock)
                )
            } coAnswers {
                onSuccessMock.captured.invoke(jokeMockDomain)
            }

            viewModel.newJoke()
            Assert.assertEquals(viewModel.joke.value, jokeMockDomain)

        }


   @Test
    fun `GIVEN the useCase is mocked WHEN JokeViewModel is called THEM the getRandom is called once with fail`() =
        dispatcher.runBlockingTest {

            val contextMock: Application = mockk(relaxed = true)
            val exceptionMock = Exception("Error")

            val jokeUseCaseImpl: JokeUseCaseImpl = mockk(relaxed = true)

            val onErrorMock = slot<(Throwable) -> Unit>()
            val viewModel = JokeViewModelImpl(contextMock, jokeUseCaseImpl)

            coEvery {
                jokeUseCaseImpl.getRandom(
                    onError = capture(onErrorMock),
                    onSuccess = any()
                )
            } coAnswers {
                onErrorMock.captured.invoke(exceptionMock)
            }

            viewModel.newJoke()

            Assert.assertEquals(viewModel.errorLiveData.value, exceptionMock)


        }

}