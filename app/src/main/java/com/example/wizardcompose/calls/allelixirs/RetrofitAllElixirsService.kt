package com.example.wizardcompose.calls.allelixirs

import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.example.wizardcompose.utils.Endpoints
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAllElixirsService {
    @GET(Endpoints.ENDPOINT_ELIXIR)
    suspend fun GetAllElixirs(): Response<List<Elixir>>

}