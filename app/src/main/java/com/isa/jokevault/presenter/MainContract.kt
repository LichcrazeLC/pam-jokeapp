package com.isa.jokevault.presenter

import com.isa.jokevault.model.Joke
import com.isa.jokevault.view.BaseView

interface MainContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onLoadJokeTapped()
    }

    interface View : BaseView<Presenter> {
        fun displayJoke(joke: Joke)
    }
}