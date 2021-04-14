package com.mrz.gropietest.model

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilding {

    companion object {
        const val BASE_URL = "http://cinema.areas.su/"
        const val BASE_URL_VIDEO = "http://cinema.areas.su/up/video/"
        const val BASE_URL_IMAGES = "http://cinema.areas.su/up/images/"

        fun buildNewRetrofit(): Retrofit {
            val client = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }

}

