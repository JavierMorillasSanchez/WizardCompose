package com.example.wizardcompose.calls.allhouses

import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.utils.Endpoints
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitHouseService {
    @GET(Endpoints.ENDPOINT_HOUSES)
    suspend fun getAllHouses(): Response<List<House>>
}