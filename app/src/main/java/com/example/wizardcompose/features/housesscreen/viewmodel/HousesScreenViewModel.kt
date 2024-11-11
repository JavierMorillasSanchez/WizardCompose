package com.example.wizardcompose.features.housesscreen.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wizardcompose.calls.allhouses.RetrofitHouseRepository
import com.example.wizardcompose.dataclasses.houseclasses.House
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class HousesScreenViewModel @Inject constructor(
    private val houseRepository: RetrofitHouseRepository
): ViewModel(), HousesScreenViewModelInterface {

    private val logTag = this.javaClass.name

    private var houseListPrepared: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private var houseList: ArrayList<House> = arrayListOf()

    override fun initiateViewModel() {
        this.houseListPrepared.value = false

        getAllHouses()
    }

    override fun getAllHouses() {

        val fetchAllHousesData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchAllHousesData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = houseRepository.getAllHouses()

            if(result.isSuccessful){

                houseList.addAll(result.body()!!)

                if(houseList.isNotEmpty()){
                    houseListPrepared.postValue(true)
                    Log.d(logTag, "Casas preparadas -> ${houseListPrepared.value}")
                }
            }
        }
    }

    override fun getHouseListPreparedValue(): MutableLiveData <Boolean> {
        return this.houseListPrepared
    }

    override fun getAllHouseList(): ArrayList<House>{
        return this.houseList
    }

}