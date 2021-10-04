package com.example.chucknorrisjokes.service.config

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig private constructor(){


    companion object {
        private lateinit var retrofit:Retrofit
        private val baseUrl = "https://api.chucknorris.io/jokes/"

        private fun getRetrofitInstance(): Retrofit{
            val httpClient = OkHttpClient.Builder()
            if (!::retrofit.isInitialized){
                retrofit = Retrofit.Builder().baseUrl(baseUrl).client(httpClient.build())
                    .addCallAdapterFactory(

                    )
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }

        fun <T> createService(serviceClass: Class<T>): T{
            return getRetrofitInstance().create(serviceClass)
        }

    }

}