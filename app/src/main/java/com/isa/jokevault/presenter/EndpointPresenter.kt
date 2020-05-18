package com.isa.jokevault.presenter

import android.util.Log
import com.isa.jokevault.DependencyInjector
import com.isa.jokevault.model.Endpoint
import com.isa.jokevault.model.EndpointRepository
import com.isa.jokevault.model.Joke
import com.isa.jokevault.model.JokeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EndpointPresenter(view: InfoContract.View, dependencyInjector: DependencyInjector) : InfoContract.Presenter, Callback<List<Endpoint>> {

    private val endpointRepository: EndpointRepository = dependencyInjector.endpointRepository()

    private var view: InfoContract.View? = view

    private fun loadEndpoints() {
        endpointRepository.loadEndpoints(this)
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadEndpoints()
    }

    override fun onResponse(call: Call<List<Endpoint>>, response: Response<List<Endpoint>>) {
        if (response.isSuccessful){
            view?.displayEndpoints(response.body()!!)
            Log.d("INFO", "HTTP GET for /v2/endpoints successful")
        }
    }

    override fun onFailure(call: Call<List<Endpoint>>, t: Throwable) {
        Log.d("ERROR", "HTTP GET for /v2/endpoints failed")

    }

}