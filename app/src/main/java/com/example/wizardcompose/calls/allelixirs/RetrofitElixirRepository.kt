package com.example.wizardcompose.calls.allelixirs

import com.example.wizardcompose.calls.allwizards.RetrofitWizardService
import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
import retrofit2.Response
import javax.inject.Inject

class RetrofitElixirRepository @Inject constructor(
    private val retrofitElixirsService: RetrofitElixirService,
) {
    suspend fun getAllElixirs(): Response<List<Elixir>>{
        return retrofitElixirsService.getAllElixirs()
    }
}