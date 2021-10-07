package com.example.chucknorrisjokes.service.config

import com.example.chucknorrisjokes.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig private constructor() {


    companion object {
        private lateinit var retrofit: Retrofit

                private val baseUrl = "https://api.chucknorris.io/jokes/"
//        private val baseUrl = "http://localhost:8080/"
        private fun getRetrofitInstance(): Retrofit {
            val httpClient = OkHttpClient.Builder()
            if (!Companion::retrofit.isInitialized) {
                retrofit = Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }

        fun <T> createService(serviceClass: Class<T>): T {
            return getRetrofitInstance().create(serviceClass)
        }

    }

}