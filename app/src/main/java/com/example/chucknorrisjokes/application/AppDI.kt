package com.example.chucknorrisjokes.application


import com.example.chucknorrisjokes.viewModel.JokeViewModel
import com.example.chucknorrisjokes.viewModel.JokeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppDI {

    val module = module {
        viewModel<JokeViewModel>(){
            JokeViewModelImpl(
                get(),
                get()
            )
        }
    }
}