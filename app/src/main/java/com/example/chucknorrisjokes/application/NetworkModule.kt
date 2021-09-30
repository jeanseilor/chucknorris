package com.example.chucknorrisjokes.application

import com.example.chucknorrisjokes.service.`interface`.ChuckNorrisService
import com.example.chucknorrisjokes.service.config.RetrofitConfig
import com.example.chucknorrisjokes.viewModel.ChuckNorrisRandomViewModel
import com.example.chucknorrisjokes.viewModel.ChuckNorrisRandomViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single

object NetworkModule {

    val networkModule = module {
        factory { RetrofitConfig.createService(ChuckNorrisService::class.java) }
    }
}