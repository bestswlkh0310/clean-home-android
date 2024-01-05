package com.bestswlkh0310.clean_home.service.api

import com.bestswlkh0310.clean_home.model.ItemModel
import retrofit2.http.GET

interface ItemApi {

    @GET("/all")
    suspend fun getAll(): ArrayList<ItemModel>

}