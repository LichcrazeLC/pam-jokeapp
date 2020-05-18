package com.isa.jokevault.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.isa.jokevault.DependencyInjectorImpl
import com.isa.jokevault.R
import com.isa.jokevault.model.Endpoint
import com.isa.jokevault.presenter.EndpointPresenter
import com.isa.jokevault.presenter.InfoContract
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(), InfoContract.View {

    private lateinit var viewAdapter: JokeInfoAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var presenter: InfoContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = LinearLayoutManager(view.context)
        viewAdapter = JokeInfoAdapter(emptyList<Endpoint>().toMutableList())

        endpoints_rec_view.apply { layoutManager = viewManager; adapter = viewAdapter }

        setPresenter(
            EndpointPresenter(
                this,
                DependencyInjectorImpl()
            )
        )
        presenter.onViewCreated()

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun displayEndpoints(endpoints: List<Endpoint>) {
        viewAdapter.updateList(endpoints)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: InfoContract.Presenter) {
        this.presenter = presenter
    }
}
