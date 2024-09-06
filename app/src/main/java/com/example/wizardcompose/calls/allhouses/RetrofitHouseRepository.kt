package com.example.wizardcompose.calls.allhouses

import com.example.wizardcompose.dataclasses.houseclasses.House
import retrofit2.Response
import javax.inject.Inject

class RetrofitHouseRepository @Inject constructor(
    private val retrofitHouseService: RetrofitHouseService
){
    suspend fun getAllHouses(): Response<List<House>> {
        return retrofitHouseService.getAllHouses()
    }
}