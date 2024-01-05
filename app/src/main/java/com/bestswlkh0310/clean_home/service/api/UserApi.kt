package com.bestswlkh0310.clean_home.service.api

import com.bestswlkh0310.clean_home.model.MessageModel
import com.bestswlkh0310.clean_home.model.UserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface UserApi {

//    @POST("/join")
//    fun join(userModel: UserModel): MessageModel

    @GET("/user")
    suspend fun getUser(): UserModel

    @PATCH("/user")
    suspend fun fixName(
        @Body userModel: UserModel
    ): UserModel

}