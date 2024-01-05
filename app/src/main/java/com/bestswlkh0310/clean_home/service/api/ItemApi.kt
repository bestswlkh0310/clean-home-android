package com.bestswlkh0310.clean_home.service.api

import com.bestswlkh0310.clean_home.model.ItemModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ItemApi {

    @GET("/item/all")
    suspend fun getAll(): ArrayList<ItemModel>

    @POST("/item/complete")
    suspend fun complete(
        @Body itemModel: ItemModel
    ): ArrayList<ItemModel>
}