package com.example.wizardcompose.di.modules

import com.example.wizardcompose.calls.allelixirs.RetrofitElixirService
import com.example.wizardcompose.calls.allelixirs.RetrofitHouseService
import com.example.wizardcompose.calls.allelixirs.RetrofitWizardService
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
object NetworkingModule {

    @Provides
    @RetrofitElixirs
    fun provideRetrofitToCallElixirs(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_ELIXIR)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @RetrofitWizards
    fun provideRetrofitToCallWizards(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_WIZARDS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @RetrofitHouses
    fun provideRetrofitToCallHouses(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_HOUSES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitElixirService(@RetrofitElixirs retrofit: Retrofit): RetrofitElixirService {
        return retrofit.create(RetrofitElixirService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitWizardService(@RetrofitWizards retrofit: Retrofit): RetrofitWizardService {
        return retrofit.create(RetrofitWizardService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitHouseService(@RetrofitHouses retrofit: Retrofit): RetrofitHouseService {
        return retrofit.create(RetrofitHouseService::class.java)
    }

}

annotation class RetrofitElixirs
annotation class RetrofitWizards
annotation class RetrofitHouses
