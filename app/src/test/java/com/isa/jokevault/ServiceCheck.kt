package com.isa.jokevault

import com.isa.jokevault.model.JokeEndpoints
import com.isa.jokevault.model.ServiceBuilder
import org.junit.Assert
import org.junit.Test

class ServiceCheck {

    @Test
    fun service_isCorrectlyCreated(){

        //Checks if the created retrofit service is correctly configured without actually making the api calls
        val service = ServiceBuilder.buildService(JokeEndpoints::class.java)

        Assert.assertEquals(
            "URL is not correct for the GET Joke endpoint",
            "https://sv443.net/jokeapi/v2/joke/any",
            service.getJoke().request().url.toString()
        )
        Assert.assertEquals(
            "URL is not correct for the GET Endpoints endpoint",
            "https://sv443.net/jokeapi/v2/endpoints",
            service.getEndpoints().request().url.toString()
        )
    }

}