package com.mrz.gropietest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrz.gropietest.model.ApiRequests
import com.mrz.gropietest.model.RetrofitBuilding
import com.mrz.gropietest.model.data.MovieItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    var number = 0
    val songTemp: MutableList<String> by lazy { mutableListOf<String>() }
    val songs: MutableLiveData<MutableList<String>> by lazy { MutableLiveData<MutableList<String>>() }

    private val nameTemp: MutableList<String> by lazy { mutableListOf<String>() }
    val names: MutableLiveData<MutableList<String>> by lazy { MutableLiveData<MutableList<String>>() }

    private val posterTemp: MutableList<String> by lazy { mutableListOf<String>() }
    val poster: MutableLiveData<MutableList<String>> by lazy { MutableLiveData<MutableList<String>>() }

    private lateinit var movieTemp: List<MovieItem>
    val movie: MutableLiveData<List<MovieItem>> by lazy { MutableLiveData<List<MovieItem>>() }

    fun plusText() {
        songTemp.add("song $number")
        number += 1
        songs.value = songTemp
    }

    fun getMovies() {
        RetrofitBuilding.buildNewRetrofit().create(ApiRequests::class.java)
            .getMovies("new").subscribeOn(
                Schedulers.newThread()
            )
            .observeOn(AndroidSchedulers.mainThread())
            .map { jsonResult ->
                movieTemp = jsonResult
                movie.value = movieTemp
            }.subscribeBy()
    }
}