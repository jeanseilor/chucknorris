package com.example.chucknorrisjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.chucknorrisjokes.fragment.ChucknorrisRandomFragment
import com.example.chucknorrisjokes.service.`interface`.ChuckNorrisService
import com.example.chucknorrisjokes.service.config.RetrofitConfig
import com.example.chucknorrisjokes.service.domain.ChuckNorris
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, ChucknorrisRandomFragment()).commit()


    }

}