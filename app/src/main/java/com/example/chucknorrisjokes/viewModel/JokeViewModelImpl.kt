package com.example.chucknorrisjokes.viewModel

import android.app.Application



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.example.chucknorrisjokes.useCase.JokeUseCase
import com.example.chucknorrisjokes.domain.JokeDomain

import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent



class JokeViewModelImpl(
    application: Application,
    private val jokeUseCase: com.example.chucknorrisjokes.useCase.JokeUseCase
) : JokeViewModel(application), KoinComponent {
    private var jokeMutable = MutableLiveData<com.example.chucknorrisjokes.domain.JokeDomain>()
    private var errorMutable = MutableLiveData<Throwable>()
    override val joke: LiveData<com.example.chucknorrisjokes.domain.JokeDomain> = jokeMutable
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