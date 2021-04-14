package com.mrz.gropietest.model

import com.mrz.gropietest.model.data.MovieItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequests {

    @GET("movies")
    fun getMovies(
        @Query("filter") filter: String): Observable<List<MovieItem>>

}