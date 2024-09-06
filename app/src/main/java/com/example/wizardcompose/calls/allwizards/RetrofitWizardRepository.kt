package com.example.wizardcompose.calls.allwizards

import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
import retrofit2.Response
import javax.inject.Inject

class RetrofitWizardRepository @Inject constructor(
    private val retrofitWizardService: RetrofitWizardService
) {
    suspend fun getAllWizards(): Response<List<Wizard>> {
        return retrofitWizardService.getAllWizards()
    }
}