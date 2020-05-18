package com.isa.jokevault.model

import android.util.Log
import retrofit2.Callback

class EndpointRepository {

    fun loadEndpoints(cb: Callback<List<Endpoint>>){

        val request = ServiceBuilder.buildService(JokeEndpoints::class.java)
        val call = request.getEndpoints()

        call.enqueue(cb)
    }
}