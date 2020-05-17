package com.isa.jokevault

import com.isa.jokevault.model.JokeRepository

class DependencyInjectorImpl : DependencyInjector {
    override fun jokeRepository() : JokeRepository {
        return JokeRepository()
    }
}