package com.isa.jokevault

import android.util.Log
import com.isa.jokevault.model.Joke
import com.isa.jokevault.model.JokeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokePresenter(view: MainContract.View, dependencyInjector: DependencyInjector) : MainContract.Presenter, Callback<Joke> {

    private val jokeRepository: JokeRepository = dependencyInjector.jokeRepository()

    private var view: MainContract.View? = view

    private fun loadJoke() {
        jokeRepository.loadJoke(this)
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadJoke()
    }

    override fun onLoadJokeTapped() {
        loadJoke()
    }

    override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
        if (response.isSuccessful){
            view?.displayJoke(response.body()!!)
            Log.d("INFO", "HTTP GET for /v2/joke/any successful")
        }
    }

    override fun onFailure(call: Call<Joke>, t: Throwable) {
        Log.d("ERROR", "HTTP GET for /v2/joke/any failed")

    }

}