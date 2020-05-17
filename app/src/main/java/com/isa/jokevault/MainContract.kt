package com.isa.jokevault

import com.isa.jokevault.model.Joke

interface MainContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onLoadJokeTapped()
    }

    interface View : BaseView<Presenter> {
        fun displayJoke(joke: Joke)
    }
}