package com.example.chucknorrisjokes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisjokes.service.`interface`.ChuckNorrisService
import com.example.chucknorrisjokes.service.config.RetrofitConfig
import com.example.chucknorrisjokes.service.domain.ChuckNorris
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChucknorrisRandomViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var instanceServiceChuckNorris: ChuckNorrisService

    private var chuckNorrisMutable = MutableLiveData<ChuckNorris>()
    val chuckNorris: LiveData<ChuckNorris> = chuckNorrisMutable


    fun setChuckNorris(chuckNorris: ChuckNorris) {
        chuckNorrisMutable.value = chuckNorris
    }


    fun newJoke() {
        instanceServiceChuckNorris = RetrofitConfig.createService(ChuckNorrisService::class.java)
        val call: Call<ChuckNorris> = instanceServiceChuckNorris.getRandom()
        call.enqueue(object : Callback<ChuckNorris> {
            override fun onResponse(call: Call<ChuckNorris>, response: Response<ChuckNorris>) {
                val chuckNorrisResponse: ChuckNorris = response.body() as ChuckNorris
                chuckNorrisMutable.value = chuckNorrisResponse // ChuckNorris
            }

            override fun onFailure(call: Call<ChuckNorris>, t: Throwable) {
                TODO()
            }

        })

    }

}