package com.mrz.gropietest.model.data

data class MovieItem(
    val age: String,
    val description: String,
    val images: List<String>,
    val movieId: String,
    var name: String,
    var poster: String,
    val tags: List<Tag>
)