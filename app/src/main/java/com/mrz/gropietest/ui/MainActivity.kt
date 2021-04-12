package com.mrz.gropietest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrz.gropietest.adapter.GroupieAdapter
import com.mrz.gropietest.databinding.ActivityMainBinding
import com.mrz.gropietest.viewmodel.MainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            viewModel.plusText()
        }

        viewModel.songs.observe(this, Observer {
            groupAdapter.clear()
            it.forEach { groupAdapter.add(GroupieAdapter(it)) }
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = groupAdapter
            }
        })



    }
}