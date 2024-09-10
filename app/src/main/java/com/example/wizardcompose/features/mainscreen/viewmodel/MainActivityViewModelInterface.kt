package com.example.wizardcompose.features.mainscreen.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.dataclasses.wizardclasses.Wizard

interface MainActivityViewModelInterface {
    fun initiateViewModel()
    fun observeWizardListPreparedValue(): MutableLiveData<Boolean>
    fun observeElixirListPreparedValue(): MutableLiveData<Boolean>
    fun observeHouseListPreparedValue(): MutableLiveData<Boolean>
    fun getAllWizardsList(): ArrayList<Wizard>
    fun getAllElixirList(): ArrayList<Elixir>
    fun getAllHouseList(): ArrayList<House>
    fun getAllElixirs()
    fun getAllWizards()
    fun getAllHouses()
}