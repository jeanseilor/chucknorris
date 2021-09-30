package com.example.chucknorrisjokes.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.maps.JokeEntityToDomain

import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.entity.JokeEntity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JokeViewModelImpl(
    application: Application,
    private val jokeService: JokeService
) : JokeViewModel(application) {
    private var jokeMutable = MutableLiveData<JokeDomain>()
    override val joke: LiveData<JokeDomain> = jokeMutable


    override fun newJoke() {
        val call: Call<JokeEntity> = jokeService.getRandom()
        call.enqueue(object : Callback<JokeEntity> {
            override fun onResponse(
                call: Call<JokeEntity>,
                response: Response<JokeEntity>
            ) {
                val jokeEntityResponse: JokeEntity = response.body() as JokeEntity
                jokeMutable.value = JokeEntityToDomain.toJokeDomain(jokeEntityResponse) // ChuckNorris
            }

            override fun onFailure(call: Call<JokeEntity>, t: Throwable) {
                TODO()
            }

        })

    }

}