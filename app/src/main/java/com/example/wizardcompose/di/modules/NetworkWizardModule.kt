package com.example.wizardcompose.di.modules

import com.example.wizardcompose.calls.allwizards.RetrofitWizardService
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
object NetworkWizardModule {

    @Provides
    fun provideRetrofitToCallWizards(): RetrofitWizardService {
        return Retrofit.Builder()
            .baseUrl(Endpoints.ENDPOINT_WIZARDS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitWizardService::class.java)
    }

}