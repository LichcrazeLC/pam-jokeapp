package com.isa.jokevault

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.isa.jokevault.model.Joke

class MainActivity : AppCompatActivity(), MainContract.View {

    internal lateinit var jokeSetup: TextView
    internal lateinit var jokeDelivery: TextView
    internal lateinit var button: Button

    internal lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jokeDelivery = findViewById(R.id.jokeDelivery)
        jokeSetup = findViewById(R.id.jokeSetup)
        button = findViewById(R.id.getJokeButton)

        setPresenter(JokePresenter(this, DependencyInjectorImpl()))
        presenter.onViewCreated()

        button.setOnClickListener { presenter.onLoadJokeTapped() }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    override fun displayJoke(joke: Joke) {
        jokeDelivery.setText(joke.delivery).toString()
        jokeSetup.setText(joke.setup).toString()
    }

}