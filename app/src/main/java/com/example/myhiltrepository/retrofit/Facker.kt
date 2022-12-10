package com.example.myhiltrepository.retrofit

import com.example.myhiltrepository.model.productItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    fun getProducts() : Call<List<productItem>>
}