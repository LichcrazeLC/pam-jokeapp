package com.isa.jokevault.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.isa.jokevault.R
import com.isa.jokevault.model.Endpoint
import kotlinx.android.synthetic.main.list_item.view.*

class JokeInfoAdapter(private val jokeEndpoints: MutableList<Endpoint>) : RecyclerView.Adapter<JokeInfoAdapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bindText (url: String?, description: String?, method: String?){
            view.endpoint_description.setText(description)
            view.endpoint_url.setText(url)
            view.method.setText(method)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeInfoAdapter.MyViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(row)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val elem = jokeEndpoints[position]
        holder.bindText(elem.usage!!.url , elem.description, elem.usage!!.method)
    }

    override fun getItemCount() = jokeEndpoints.size

    public fun updateList(dataSet: List<Endpoint>) {
        jokeEndpoints.clear()
        jokeEndpoints.addAll(dataSet)
        notifyDataSetChanged()
    }

}