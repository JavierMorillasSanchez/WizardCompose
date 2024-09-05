package com.example.wizardcompose.features.mainscreen.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.wizardcompose.calls.allelixirs.RetrofitAllElixirsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val allElixirsUseCase: RetrofitAllElixirsRepository
): ViewModel() {

    private val logTag = this.javaClass.name

    fun getAllElixirs() {

        val fetchRandomUserData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchRandomUserData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = allElixirsUseCase.getAllElixirs()

            Log.d(logTag, "")


            for(position in 0 until (result.body()?.size ?: 0)) {
                Log.d(logTag, "Elixir número $position -> ${result.body()?.get(position)}")
            }
        }
    }

}