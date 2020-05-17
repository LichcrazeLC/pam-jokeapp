package com.isa.jokevault.model

import android.util.Log
import retrofit2.Callback

class JokeRepository {

    fun loadJoke(cb: Callback<Joke>){

        Log.d("INFO", "request created!")
        val request = ServiceBuilder.buildService(JokeEndpoints::class.java)
        val call = request.getJoke()

        call.enqueue(cb)
    }
}