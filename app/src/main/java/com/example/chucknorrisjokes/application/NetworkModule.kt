package com.example.chucknorrisjokes.application

import com.example.chucknorrisjokes.datasource.JokeDatasource
import com.example.chucknorrisjokes.datasource.JokeDatasourceImpl
import com.example.chucknorrisjokes.repository.JokeRepository
import com.example.chucknorrisjokes.repository.JokeRepositoryImpl
import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.config.RetrofitConfig
import com.example.chucknorrisjokes.useCase.JokeUseCase
import com.example.chucknorrisjokes.useCase.JokeUseCaseImpl
import org.koin.dsl.module

object NetworkModule {

    val networkModule = module {
        factory { RetrofitConfig.createService(JokeService::class.java) }
        factory<JokeRepository>{ JokeRepositoryImpl(get())}
        factory<JokeUseCase>{ JokeUseCaseImpl(get())}
        factory<JokeDatasource>{ JokeDatasourceImpl(get())}
    }
}