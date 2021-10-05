package com.example.chucknorrisjokes.viewModel

import android.app.Application
import android.util.Log


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisjokes.domain.JokeDomain

import com.example.chucknorrisjokes.useCase.JokeUseCase

import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import java.lang.Exception


class JokeViewModelImpl(
    application: Application,
    private val jokeUseCase: JokeUseCase
) : JokeViewModel(application), KoinComponent {
    private var jokeMutable = MutableLiveData<JokeDomain>()
    private var errorMutable = MutableLiveData<Throwable>()
    override val joke: LiveData<JokeDomain> = jokeMutable
    override val errorLiveData: LiveData<Throwable> = errorMutable


    override fun newJoke() {
        viewModelScope.launch {
            jokeUseCase.getRandom(onError = {
                errorMutable.value = it
            },
            onSuccess = {
                jokeMutable.value = it
            })

        }
    }




}