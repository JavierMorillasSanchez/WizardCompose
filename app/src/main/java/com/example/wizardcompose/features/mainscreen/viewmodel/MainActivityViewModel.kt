package com.example.wizardcompose.features.mainscreen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.wizardcompose.calls.allelixirs.RetrofitElixirRepository
import com.example.wizardcompose.calls.allhouses.RetrofitHouseRepository
import com.example.wizardcompose.calls.allwizards.RetrofitWizardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val elixirRepository: RetrofitElixirRepository,
    private val wizardRepository: RetrofitWizardRepository,
    private val houseRepository: RetrofitHouseRepository
): ViewModel() {

    private val logTag = this.javaClass.name

    fun getAllElixirs() {

        val fetchAllElixirData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchAllElixirData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = elixirRepository.getAllElixirs()

            Log.d(logTag, "Elixir con ID ${result.body()?.get(0)} -> ${result.body()?.get(0)?.name}")

        }
    }

    fun getAllWizards() {

        val fetchAllWizardsData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchAllWizardsData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = wizardRepository.getAllWizards()

            Log.d(logTag, "Mago con ID ${result.body()?.get(0)} -> ${result.body()?.get(0)?.firstName} ${result.body()?.get(0)?.lastName}")

        }
    }

    fun getAllHouses() {

        val fetchAllHousesData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchAllHousesData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = houseRepository.getAllHouses()

            Log.d(logTag, "Casa con ID ${result.body()?.get(0)} -> ${result.body()?.get(0)?.name}")

        }
    }

}