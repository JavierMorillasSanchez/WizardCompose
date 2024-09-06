package com.example.wizardcompose.calls.allwizards

import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
import com.example.wizardcompose.utils.Endpoints
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitWizardService {
    @GET(Endpoints.ENDPOINT_WIZARDS)
    suspend fun getAllWizards(): Response<List<Wizard>>
}