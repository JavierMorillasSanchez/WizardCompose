package com.example.wizardcompose.features.housesscreen.uihousesscreen

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.features.housesscreen.viewmodel.HousesScreenViewModel

@Composable
fun HousesScreenComposeUIGenerator(viewModel: HousesScreenViewModel = viewModel()){

    viewModel.initiateViewModel()

    val houseList = remember { mutableStateListOf<House>() }
    val isHouseListPrepared = viewModel.getHouseListPreparedValue().observeAsState(initial = false)

    if (isHouseListPrepared.value) {

        if(houseList.isEmpty()){
            houseList.addAll(viewModel.getAllHouseList())
            for((index,house) in houseList.withIndex()){
                Log.d("logTag", "Casa Posición -> ${houseList[index]}")
                Log.d("logTag", "Casa Lista -> ${house.name}")
            }
        }

    }

}