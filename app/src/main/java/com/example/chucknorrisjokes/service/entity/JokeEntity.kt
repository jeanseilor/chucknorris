package com.example.chucknorrisjokes.service.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class JokeEntity(){

   var value: String = ""
}