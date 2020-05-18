package com.isa.jokevault.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.isa.jokevault.DependencyInjectorImpl
import com.isa.jokevault.R
import com.isa.jokevault.presenter.JokePresenter
import com.isa.jokevault.presenter.MainContract
import com.isa.jokevault.model.Joke

class MainActivity : AppCompatActivity(), MainContract.View {

    internal lateinit var jokeSetup: TextView
    internal lateinit var jokeDelivery: TextView
    internal lateinit var getJokeButton: Button
    internal lateinit var jokeAPIInfo: Button

    internal lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jokeDelivery = findViewById(R.id.jokeDelivery)
        jokeSetup = findViewById(R.id.jokeSetup)
        getJokeButton = findViewById(R.id.getJokeButton)
        jokeAPIInfo = findViewById(R.id.getJokeInfo)

        setPresenter(
            JokePresenter(
                this,
                DependencyInjectorImpl()
            )
        )
        presenter.onViewCreated()

        getJokeButton.setOnClickListener { presenter.onLoadJokeTapped() }
        jokeAPIInfo.setOnClickListener { switchActivity()}
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    override fun displayJoke(joke: Joke) {
        if (joke.type == "twopart") {
            jokeDelivery.setText(joke.delivery).toString()
            jokeSetup.setText(joke.setup).toString()
        } else {
            jokeSetup.setText(null)
            jokeDelivery.setText(joke.joke).toString()
        }
    }

    fun switchActivity() {
        val intent = Intent(this, JokeInfoActivity::class.java)
        startActivity(intent)
    }

}