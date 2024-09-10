package com.example.wizardcompose.features.mainscreen.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wizardcompose.calls.allelixirs.RetrofitElixirRepository
import com.example.wizardcompose.calls.allhouses.RetrofitHouseRepository
import com.example.wizardcompose.calls.allwizards.RetrofitWizardRepository
import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
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
): ViewModel(), MainActivityViewModelInterface {

    private val logTag = this.javaClass.name

    private var wizardListPrepared: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private var houseListPrepared: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private var elixirListPrepared: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    private var wizardList: ArrayList<Wizard> = arrayListOf()
    private var houseList: ArrayList<House> = arrayListOf()
    private var elixirList: ArrayList<Elixir> = arrayListOf()

    override fun initiateViewModel(){
        this.wizardListPrepared.value = false
        this.houseListPrepared.value = false
        this.elixirListPrepared.value = false

        getAllElixirs()
        getAllHouses()
        getAllWizards()

    }

    override fun observeWizardListPreparedValue(): MutableLiveData <Boolean> {
        return this.wizardListPrepared
    }
    override fun observeElixirListPreparedValue(): MutableLiveData <Boolean> {
        return this.elixirListPrepared
    }
    override fun observeHouseListPreparedValue(): MutableLiveData <Boolean> {
        return this.houseListPrepared
    }

    override fun getAllWizardsList(): ArrayList<Wizard>{
        return this.wizardList
    }

    override fun getAllElixirList(): ArrayList<Elixir>{
        return this.elixirList
    }

    override fun getAllHouseList(): ArrayList<House>{
        return this.houseList
    }

    override fun getAllElixirs() {

        val fetchAllElixirData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchAllElixirData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = elixirRepository.getAllElixirs()

            if(result.isSuccessful){

                for((index, elixir) in result.body()!!.withIndex()){

                    elixirList.add(elixir)

                    Log.d(logTag, "Elixir guardado -> ${elixirList.get(index).name} " +
                            "con ID ${elixirList.get(index).id}")

                    if(index == result.body()!!.size){
                        elixirListPrepared.postValue(true)
                    }
                }
            }


        }
    }

    override fun getAllWizards() {

        val fetchAllWizardsData = Job()

        val errorHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Error ---> ${throwable.message}")
        }

        val scope = CoroutineScope(fetchAllWizardsData + Dispatchers.Main)

        scope.launch(errorHandler){

            val result = wizardRepository.getAllWizards()

            if(result.isSuccessful){

                for((index, wizard) in result.body()!!.withIndex()){

                    wizardList.add(wizard)

                    Log.d(logTag, "Mago guardado -> ${wizardList.get(index).firstName} " +
                            "${wizardList.get(index).lastName} " +
                            "con ID ${wizardList.get(index).id}")

                    if(index == result.body()!!.size){
                        wizardListPrepared.postValue(true)
                    }
                }
            }
        }
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

                for((index, house) in result.body()!!.withIndex()){

                    houseList.add(house)

                    Log.d(logTag, "Casa guardada -> ${houseList.get(index).name} " +
                            "con ID ${houseList.get(index).id}")

                    if(index == result.body()!!.size){
                        houseListPrepared.postValue(true)
                    }
                }
            }
        }
    }

}