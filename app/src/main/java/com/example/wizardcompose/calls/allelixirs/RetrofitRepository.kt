package com.example.wizardcompose.calls.allelixirs

import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(
    private val retrofitElixirsService: RetrofitElixirService,
    private val retrofitWizardService: RetrofitWizardService,
    private val retrofitHouseService: RetrofitHouseService
) {

    suspend fun getAllElixirs(): Response<List<Elixir>>{
        return retrofitElixirsService.getAllElixirs()
    }

    suspend fun getAllWizards(): Response<List<Wizard>>{
        return retrofitWizardService.getAllWizards()
    }

    suspend fun getAllHouses(): Response<List<House>>{
        return retrofitHouseService.getAllHouses()
    }

}