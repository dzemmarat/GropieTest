package com.mrz.gropietest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrz.gropietest.adapter.GroupieAdapter

class MainViewModel : ViewModel() {
    var number = 0
    val songs: MutableLiveData<MutableList<String>> by lazy { MutableLiveData<MutableList<String>>() }
    val song: MutableList<String> by lazy { mutableListOf<String>() }

    fun plusText() {
        song.add("song $number")
        number += 1
        songs.value = song
    }
}