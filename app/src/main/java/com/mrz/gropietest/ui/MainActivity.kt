package com.mrz.gropietest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrz.gropietest.adapter.GroupieAdapter
import com.mrz.gropietest.databinding.ActivityMainBinding
import com.mrz.gropietest.model.ApiRequests
import com.mrz.gropietest.model.RetrofitBuilding
import com.mrz.gropietest.viewmodel.MainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.create

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
//            viewModel.plusText()
            viewModel.getMovies()
            Toast.makeText(this, viewModel.names.toString(), Toast.LENGTH_SHORT).show()
        }

//        viewModel.songs.observe(this, {
//            groupAdapter.clear()
//            it.forEach { item -> groupAdapter.add(GroupieAdapter(item)) }
//            binding.recyclerView.apply {
//                layoutManager = LinearLayoutManager(this@MainActivity)
//                adapter = groupAdapter
//            }
//        })

        viewModel.movie.observe(this, {
            groupAdapter.clear()
            for (position in 0 until it.size) {
                groupAdapter.add(GroupieAdapter(it[position].name, it[position].poster))
            }
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = groupAdapter
            }
        })


    }

}