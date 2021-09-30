package com.example.chucknorrisjokes.application

import com.example.chucknorrisjokes.service.`interface`.JokeService
import com.example.chucknorrisjokes.service.config.RetrofitConfig
import org.koin.dsl.module

object NetworkModule {

    val networkModule = module {
        factory { RetrofitConfig.createService(JokeService::class.java) }
    }
}