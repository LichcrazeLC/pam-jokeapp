package com.isa.jokevault.model

import retrofit2.Call
import retrofit2.http.GET

interface JokeEndpoints {
    @GET("v2/joke/any")
    fun getJoke(): Call<Joke>
}