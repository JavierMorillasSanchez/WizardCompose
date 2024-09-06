package com.example.wizardcompose.features.mainscreen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.wizardcompose.calls.allelixirs.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val retrofitRepository: RetrofitRepository
): ViewModel() {

    private val logTag = this.javaClass.name

    fun getAllElixirs() {

        val fetchRandomUserData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchRandomUserData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = retrofitRepository.getAllElixirs()

            Log.d(logTag, "Elixir con ID ${result.body()?.get(0)} -> ${result.body()?.get(0)?.name}")

        }
    }

    fun getAllWizards() {

        val fetchRandomUserData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchRandomUserData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = retrofitRepository.getAllWizards()

            Log.d(logTag, "Mago con ID ${result.body()?.get(0)} -> ${result.body()?.get(0)?.firstName} ${result.body()?.get(0)?.lastName}")

        }
    }

    fun getAllHouses() {

        val fetchRandomUserData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchRandomUserData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = retrofitRepository.getAllHouses()

            Log.d(logTag, "Casa con ID ${result.body()?.get(0)} -> ${result.body()?.get(0)?.name}")

        }
    }

}