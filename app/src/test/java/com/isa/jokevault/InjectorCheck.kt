package com.isa.jokevault

import com.isa.jokevault.model.EndpointRepository
import com.isa.jokevault.model.JokeRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InjectorCheck {

    lateinit var depInjector: DependencyInjectorImpl

    @Before
    fun onSetup() {
        depInjector = DependencyInjectorImpl()
    }

    @Test
    fun injector_isCorrect(){

        //Checks if the dependency injector methods return the right class type object
        val jokeRepo = depInjector.jokeRepository()
        val endpointRepo = depInjector.endpointRepository()

        Assert.assertEquals(
            "Instance not correctly returned",
            JokeRepository::class,
            jokeRepo::class
        )
        Assert.assertEquals(
            "Instance not correctly returned",
            EndpointRepository::class,
            endpointRepo::class
        )
    }
}