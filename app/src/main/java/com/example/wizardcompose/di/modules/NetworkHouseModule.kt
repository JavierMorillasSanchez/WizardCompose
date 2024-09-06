package com.example.wizardcompose.di.modules

import com.example.wizardcompose.calls.allhouses.RetrofitHouseService
import com.example.wizardcompose.utils.Endpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkHouseModule {

    @Provides
    fun provideRetrofitToCallHouses(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_HOUSES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitHouseService(retrofit: Retrofit): RetrofitHouseService {
        return retrofit.create(RetrofitHouseService::class.java)
    }
}