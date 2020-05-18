package com.isa.jokevault.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.isa.jokevault.R

import kotlinx.android.synthetic.main.activity_joke_info.*

class JokeInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_info)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { switchActivity() }
    }

    fun switchActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
