package com.isa.jokevault

import com.isa.jokevault.model.EndpointRepository
import com.isa.jokevault.model.JokeRepository

interface DependencyInjector {
    fun jokeRepository() : JokeRepository
    fun endpointRepository() : EndpointRepository
}