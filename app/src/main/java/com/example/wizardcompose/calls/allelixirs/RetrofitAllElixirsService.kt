package com.example.wizardcompose.calls.allelixirs

import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAllElixirsService {
    @GET
    suspend fun GetAllElixirs(): Response<List<Elixir>>

}