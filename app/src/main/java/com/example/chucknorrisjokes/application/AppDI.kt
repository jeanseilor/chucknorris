package com.example.chucknorrisjokes.application

import com.example.chucknorrisjokes.service.config.RetrofitConfig
import com.example.chucknorrisjokes.viewModel.ChuckNorrisRandomViewModel
import com.example.chucknorrisjokes.viewModel.ChuckNorrisRandomViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single

object AppDI {

    val module = module {
        viewModel<ChuckNorrisRandomViewModel>(){ChuckNorrisRandomViewModelImpl(get(), get())}
    }

//    // single instance of HelloRepository
//    single<HelloRepository> { HelloRepositoryImpl() }
//
//    factory { MySimplePresenter(get()) }
}