package com.example.chucknorrisjokes.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisjokes.domain.JokeDomain
import com.example.chucknorrisjokes.maps.JokeEntityToDomain

import com.example.chucknorrisjokes.service.entity.JokeEntity
import com.example.chucknorrisjokes.useCase.JokeUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JokeViewModelImpl(
    application: Application,
) : JokeViewModel(application), KoinComponent {
    private var jokeMutable = MutableLiveData<JokeDomain>()
    override val joke: LiveData<JokeDomain> = jokeMutable
    private val jokeUseCase: JokeUseCase by inject()

    override fun newJoke() {
        CoroutineScope(Dispatchers.IO).launch {
            jokeMutable.postValue(jokeUseCase.getRandom())
        }
    }




}