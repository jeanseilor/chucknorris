package com.example.chucknorrisjokes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.example.chucknorrisjokes.domain.JokeDomain

abstract class JokeViewModel(application:Application): AndroidViewModel(application) {
    abstract val joke: LiveData<com.example.chucknorrisjokes.domain.JokeDomain>
    abstract val errorLiveData: LiveData<Throwable>
    abstract  fun newJoke()
}