package com.skgames.trafficridert.api

import com.skgames.trafficridert.data.GeoDev
import retrofit2.Response
import retrofit2.http.GET

interface HostInterface {

    @GET("const.json")
    suspend fun getDataDev(): Response<GeoDev>
}