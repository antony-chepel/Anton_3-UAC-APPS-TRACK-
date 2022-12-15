package com.skgames.trafficridert.di

import com.skgames.trafficridert.api.ApiInterface
import com.skgames.trafficridert.api.HostInterface
import com.skgames.trafficridert.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@OptIn(ExperimentalCoroutinesApi::class)
@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)
    @Provides
    @Singleton
    fun provideRetrofitApi() : ApiInterface {
       return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .client(okHttpClient.build())
            .build()
           .create(ApiInterface::class.java)
    }


    @Provides
    @Singleton
    fun provideRetrofitHosting() : HostInterface {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://onyxexcitement.live/")
            .client(okHttpClient.build())
            .build()
            .create(HostInterface::class.java)
    }


    @Singleton
    @Provides
    fun providesRepository(apiService: ApiInterface,hostInterface: HostInterface) = Repository(apiService,hostInterface)
    }





