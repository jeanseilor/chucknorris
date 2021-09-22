package com.example.chucknorrisjokes.service.`interface`

import com.example.chucknorrisjokes.service.domain.ChuckNorris
import retrofit2.Call
import retrofit2.http.GET

interface ChuckNorrisService {

    @GET("random")
    fun getRandom(): Call<ChuckNorris>
}