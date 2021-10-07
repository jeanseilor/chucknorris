package com.example.chucknorrisjokes.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.chucknorrisjokes.R


import com.example.chucknorrisjokes.viewModel.JokeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class JokeRandomFragment : Fragment() {

    private lateinit var textChuck: TextView;
    
    private lateinit var buttonNewJoke:Button

    private val jokeRandomViewModel: JokeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_chucknorris_random, container, false)


        textChuck = view.findViewById(R.id.text_view_chuck)
        jokeRandomViewModel.joke.observe(this.viewLifecycleOwner, {
            textChuck.text = it.value

        })

        buttonNewJoke = view.findViewById(R.id.button_new_joke)
        buttonNewJoke.setOnClickListener {
            jokeRandomViewModel.newJoke()
        }
        return view
    }

}