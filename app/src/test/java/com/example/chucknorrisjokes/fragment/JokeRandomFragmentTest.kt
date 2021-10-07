package com.example.chucknorrisjokes.fragment

import android.os.Build
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.testing.FragmentScenario


import androidx.lifecycle.Lifecycle
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.domain.JokeDomain

import com.example.chucknorrisjokes.repository.JokeRepository
import com.example.chucknorrisjokes.service.entity.JokeEntity
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config



@RunWith(RobolectricTestRunner::class)
@Config(
    sdk = [Build.VERSION_CODES.P]
)
class JokeRandomFragmentTest {

    private val jokeRepository: JokeRepository = mockk()

    @Before
    fun setup(){
        loadKoinModules(module {
            single { jokeRepository }
        })

    }

    @Test
    fun `WHEN main activity is created THEN fragment is created with correctly instance`() {
        val jokeRandomFragment = FragmentScenario.launchInContainer(JokeRandomFragment::class.java)
        jokeRandomFragment.moveToState(Lifecycle.State.CREATED)
        jokeRandomFragment.onFragment{
            it shouldNotBe null
        }

    }

    @Test
    fun `WHEN main activity is created `()  {
        val jokeMockDomain = JokeDomain("value1")
        val jokeEntityMock = JokeEntity("value1")

        coEvery { jokeRepository.getRandom() } returns jokeEntityMock

        val jokeRandomFragment = FragmentScenario.launchInContainer(JokeRandomFragment::class.java)
        jokeRandomFragment.onFragment{
            it.view?.findViewById<Button>(R.id.button_new_joke)?.callOnClick()
            val text = it.view?.findViewById<TextView>(R.id.text_view_chuck)
            text?.text shouldBe jokeMockDomain.value
        }

    }


}