package com.example.chucknorrisjokes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.chucknorrisjokes.domain.JokeDomain
import java.lang.Exception

abstract class JokeViewModel(application:Application): AndroidViewModel(application) {
    abstract val joke: LiveData<JokeDomain>
    abstract val errorLiveData: LiveData<Throwable>
    abstract  fun newJoke()
}