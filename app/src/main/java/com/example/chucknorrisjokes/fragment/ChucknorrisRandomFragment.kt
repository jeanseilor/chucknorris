package com.example.chucknorrisjokes.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.R.id.button_new_joke
import com.example.chucknorrisjokes.R.id.text_view_chuck
import com.example.chucknorrisjokes.service.`interface`.ChuckNorrisService
import com.example.chucknorrisjokes.service.config.RetrofitConfig
import com.example.chucknorrisjokes.service.domain.ChuckNorris
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChucknorrisRandomFragment : Fragment() {

    private lateinit var textChuck: TextView;
    private lateinit var buttonNewJoke:Button
    private lateinit var instanceServiceChuckNorris: ChuckNorrisService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        instanceServiceChuckNorris = RetrofitConfig.createService(ChuckNorrisService::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_chucknorris_random, container, false)
        textChuck = view.findViewById(text_view_chuck)
        buttonNewJoke = view.findViewById(button_new_joke)
        buttonNewJoke.setOnClickListener {
            newJoke()
        }
        return view
    }


    private fun newJoke() {
        val call: Call<ChuckNorris> =  instanceServiceChuckNorris.getRandom()
        call.enqueue(object : Callback<ChuckNorris> {
            override fun onResponse(call: Call<ChuckNorris>, response: Response<ChuckNorris>) {
                val chuckNorrisResponse: ChuckNorris = response.body() as ChuckNorris
                textChuck.text = chuckNorrisResponse.value
            }
            override fun onFailure(call: Call<ChuckNorris>, t: Throwable) {
                TODO()
            }

        })

    }
}