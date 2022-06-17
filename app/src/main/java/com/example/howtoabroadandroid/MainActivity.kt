package com.example.howtoabroadandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.howtoabroadandroid.Adapters.PostAdapter
import com.example.howtoabroadandroid.repository.Repository
import com.example.howtoabroadandroid.viewmodel.MainViewModel
import com.example.howtoabroadandroid.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    private val adapter : PostAdapter by lazy {
        PostAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        fetch.setOnClickListener {
            viewModel.getAllPosts()
        }

        viewModel.mutableLiveData.observe(this, Observer {
            adapter.submitList(it)
        })


    }

    private fun setupRecyclerView(){
        rvPosts.layoutManager = LinearLayoutManager(this)
        rvPosts.adapter = adapter
    }
}