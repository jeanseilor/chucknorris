package com.example.chucknorrisjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.chucknorrisjokes.service.`interface`.ChuckNorrisService
import com.example.chucknorrisjokes.service.config.RetrofitConfig
import com.example.chucknorrisjokes.service.domain.ChuckNorris
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var textChuck:TextView;
    private lateinit var instanceServiceChuckNorris:ChuckNorrisService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textChuck = findViewById(R.id.text_view_chuck)
        instanceServiceChuckNorris = RetrofitConfig.createService(ChuckNorrisService::class.java)

    }
    fun newJoke(view: View) {

        val call:Call<ChuckNorris> =  instanceServiceChuckNorris.getRandom()

        call.enqueue(object : Callback<ChuckNorris>{
            override fun onResponse(call: Call<ChuckNorris>, response: Response<ChuckNorris>) {

                val chuckNorrisResponse:ChuckNorris = response.body() as ChuckNorris
                textChuck.text = chuckNorrisResponse.value
            }

            override fun onFailure(call: Call<ChuckNorris>, t: Throwable) {
                val s = t.message
                print(s)
            }

        })

    }
}