package com.isa.jokevault.presenter

import com.isa.jokevault.model.Endpoint
import com.isa.jokevault.view.BaseView

interface InfoContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
    }

    interface View : BaseView<Presenter> {
        fun displayEndpoints(endpoints: List<Endpoint>)
    }
}