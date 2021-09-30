package com.example.chucknorrisjokes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.chucknorrisjokes.model.ChuckNorris

abstract class ChuckNorrisRandomViewModel(application:Application): AndroidViewModel(application) {
    abstract val chuckNorris: LiveData<ChuckNorris>
    abstract fun newJoke()
}