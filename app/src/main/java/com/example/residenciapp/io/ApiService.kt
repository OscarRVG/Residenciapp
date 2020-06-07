package com.example.residenciapp.io

import com.example.residenciapp.model.AreaComun
import retrofit2.Call
import retrofit2.Retrofit
import  retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("areascomunes")
    abstract fun getAreasComunes(): Call<ArrayList<AreaComun>>

    companion object Factory{
        private const val BASE_URL = "https://residenciapp.com/api/"

        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
    
}