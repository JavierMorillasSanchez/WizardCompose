package com.example.wizardcompose.features.housesscreen.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.wizardcompose.dataclasses.houseclasses.House

interface HousesScreenViewModelInterface {
    fun initiateViewModel()
    fun getAllHouses()
    fun getHouseListPreparedValue(): MutableLiveData<Boolean>
    fun getAllHouseList(): ArrayList<House>
}