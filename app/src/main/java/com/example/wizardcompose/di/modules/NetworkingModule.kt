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
    fun provideRetrofitToCallElixirs(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_ELIXIR)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideRetrofitToCallWizards(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_WIZARDS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideRetrofitToCallHouses(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_HOUSES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitElixirService(retrofit: Retrofit): RetrofitElixirService {
        return retrofit.create(RetrofitElixirService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitWizardService(retrofit: Retrofit): RetrofitWizardService {
        return retrofit.create(RetrofitWizardService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitHouseService(retrofit: Retrofit): RetrofitHouseService {
        return retrofit.create(RetrofitHouseService::class.java)
    }

}
