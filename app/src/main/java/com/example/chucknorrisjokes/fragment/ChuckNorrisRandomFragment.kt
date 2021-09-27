package com.example.chucknorrisjokes.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.R.id.button_new_joke
import com.example.chucknorrisjokes.R.id.text_view_chuck
import com.example.chucknorrisjokes.viewModel.ChucknorrisRandomViewModel


class ChucknorrisRandomFragment : Fragment() {

    private lateinit var textChuck: TextView;
    
    private lateinit var buttonNewJoke:Button

    private lateinit var viewModel:ChucknorrisRandomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_chucknorris_random, container, false)
        viewModel = ViewModelProvider(this)[ChucknorrisRandomViewModel::class.java]

        textChuck = view.findViewById(text_view_chuck)
        viewModel.chuckNorris.observe(this.viewLifecycleOwner, {
            textChuck.text = it.value
        })
//        viewModel.chuckNorris
        buttonNewJoke = view.findViewById(button_new_joke)
        buttonNewJoke.setOnClickListener {
            viewModel.newJoke()
        }
        return view
    }



}