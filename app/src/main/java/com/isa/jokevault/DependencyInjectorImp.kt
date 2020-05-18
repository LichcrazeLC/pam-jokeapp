package com.isa.jokevault

import com.isa.jokevault.model.EndpointRepository
import com.isa.jokevault.model.JokeRepository

class DependencyInjectorImpl : DependencyInjector {
    override fun jokeRepository() : JokeRepository {
        return JokeRepository()
    }
    override fun endpointRepository() : EndpointRepository {
        return EndpointRepository()
    }
}