package com.example.wizardcompose.calls.allelixirs

import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import retrofit2.Response
import javax.inject.Inject

class RetrofitAllElixirsRepository @Inject constructor(
    private val allElixirsService: RetrofitAllElixirsService
) {

    suspend fun getAllElixirs(): Response<List<Elixir>>{
        return allElixirsService.GetAllElixirs()
    }

}