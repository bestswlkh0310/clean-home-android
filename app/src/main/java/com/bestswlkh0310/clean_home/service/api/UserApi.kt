package com.bestswlkh0310.clean_home.service.api

import com.bestswlkh0310.clean_home.model.MessageModel
import com.bestswlkh0310.clean_home.model.UserModel
import retrofit2.http.PATCH
import retrofit2.http.POST

interface UserApi {

//    @POST("/join")
//    fun join(userModel: UserModel): MessageModel

    @PATCH("/name")
    suspend fun fixName(userModel: UserModel): UserModel

}