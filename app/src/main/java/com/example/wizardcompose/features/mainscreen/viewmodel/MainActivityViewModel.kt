package com.example.wizardcompose.features.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wizardcompose.calls.allelixirs.RetrofitAllElixirsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val allElixirsUseCase: RetrofitAllElixirsRepository
): ViewModel() {

}