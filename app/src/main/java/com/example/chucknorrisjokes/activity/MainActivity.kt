package com.example.chucknorrisjokes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.fragment.ChucknorrisRandomFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, ChucknorrisRandomFragment()).commit()
        }
    }

}