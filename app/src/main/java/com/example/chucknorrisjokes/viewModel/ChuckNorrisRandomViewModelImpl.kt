package com.example.chucknorrisjokes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisjokes.model.ChuckNorris

import com.example.chucknorrisjokes.service.`interface`.ChuckNorrisService
import com.example.chucknorrisjokes.service.config.RetrofitConfig
import com.example.chucknorrisjokes.service.domain.ChuckNorrisDomain

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChuckNorrisRandomViewModelImpl(
    application: Application,
    private val chuckNorrisService: ChuckNorrisService
) : ChuckNorrisRandomViewModel(application) {
    private var chuckNorrisMutable = MutableLiveData<ChuckNorris>()
    override val chuckNorris: LiveData<ChuckNorris> = chuckNorrisMutable


    override fun newJoke() {
        val call: Call<ChuckNorrisDomain> = chuckNorrisService.getRandom()
        call.enqueue(object : Callback<ChuckNorrisDomain> {
            override fun onResponse(
                call: Call<ChuckNorrisDomain>,
                response: Response<ChuckNorrisDomain>
            ) {
                val chuckNorrisResponse: ChuckNorrisDomain = response.body() as ChuckNorrisDomain
                chuckNorrisMutable.value = ChuckNorris(chuckNorrisResponse.value) // ChuckNorris
            }

            override fun onFailure(call: Call<ChuckNorrisDomain>, t: Throwable) {
                TODO()
            }

        })

    }

}