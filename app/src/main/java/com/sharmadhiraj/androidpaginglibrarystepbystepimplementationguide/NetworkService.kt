package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {


   // page=1&pagesize=30&site=stackoverflow

    @GET("/2.2/answers")
    fun getNews(@Query("page") page: Int,
                @Query("pageSize") pageSize: Int,
                @Query("site") site: String): Single<Response>

    companion object {
        fun getService(): NetworkService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.stackexchange.com")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(NetworkService::class.java)
        }
    }

}