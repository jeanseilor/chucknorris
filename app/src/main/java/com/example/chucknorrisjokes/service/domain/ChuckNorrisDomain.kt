package com.example.chucknorrisjokes.service.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.util.*
import kotlin.collections.ArrayList

@JsonIgnoreProperties(ignoreUnknown = true)
class ChuckNorrisDomain(){

   var value: String = ""
}