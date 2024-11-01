package com.example.wizardcompose.di.modules

import com.example.wizardcompose.calls.allelixirs.RetrofitElixirService
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
object NetworkingElixirModule {

    @Provides
    fun provideRetrofitToCallElixirs(): RetrofitElixirService {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_ELIXIR)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitElixirService::class.java)
    }

}
