package com.skgames.trafficridert.api

import com.skgames.trafficridert.data.CountryCodeJS
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=mFBNVQSnCdDASI9")
    suspend fun getData(): Response<CountryCodeJS>


}



