package com.example.wizardcompose.features.mainscreen.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.example.wizardcompose.dataclasses.elixirclasses.Ingredient
import com.example.wizardcompose.dataclasses.elixirclasses.Inventor
import com.example.wizardcompose.dataclasses.houseclasses.Head
import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.dataclasses.houseclasses.Trait
import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
import com.example.wizardcompose.features.mainscreen.uimainscreen.MainActivityComposeUIGenerator
import com.example.wizardcompose.features.mainscreen.viewmodel.MainActivityViewModel
import com.example.wizardcompose.ui.theme.WizardComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainActivityInterface {

    private val logTag = this.javaClass.name

    private val viewModel: MainActivityViewModel by viewModels()

    private var wizardList: ArrayList<Wizard> = arrayListOf()
    private var houseList: ArrayList<House> = arrayListOf()
    private var elixirList: ArrayList<Elixir> = arrayListOf()

    /**
     Los siguientes objetos se van a usar para hacer pruebas
     */

    private val sampleIngredientObject = Ingredient(
        "97128d90-bf57-49e5-b314-417baddb2d78",
        "Nagini's venom"
    )

    private val sampleInventorObject = Inventor(
        "9b528a63-0a01-4b91-992d-9afed9b841e7",
        "Linfred",
        "of Stinchcombe"
    )

    private val sampleHeadObject = Head(
        "530da97d-5a83-4ea6-bc15-790edf5b5efc",
        "Minerva",
        "McGonagall"
    )

    private val sampleTraitObject = Trait(
        "1773bce8-7a22-4d57-b8e1-7e1cbe26fa2b",
        "Courage"
    )


    private val sampleElixirObject = Elixir(
        "d14ca162-df3f-4053-a3c9-58de82041646",
        "Kissing Concoction",
        null,
        null,
        null,
        null,
        null,
        null
    )

    private val sampleHeadArray = arrayListOf<Head>(
        sampleHeadObject,
        sampleHeadObject,
        sampleHeadObject
    )

    private val sampleElixirArray = arrayListOf<Elixir>(
        sampleElixirObject,
        sampleElixirObject,
        sampleElixirObject
    )

    private val sampleTraitArray = arrayListOf<Trait>(
        sampleTraitObject,
        sampleTraitObject,
        sampleTraitObject
    )

    private val sampleHouseObject = House(
        "0367baf3-1cb6-4baf-bede-48e17e1cd005",
        "Gryffindor",
        "Scarlet and gold",
        "Godric Gryffindor",
        "Lion",
        "Fire",
        "Nearly-Headless Nick",
        "Gryffindor Tower",
        sampleHeadArray
    )

    private val sampleWizardObject = Wizard(
        "118e7366-1c65-4275-8121-8f6c553e5783",
        "Fred",
        "Weasley",
        sampleElixirArray
    )

    /**
     * Eliminar objetos de prueba
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initiateViewModel()

        setContent {
            WizardComposeTheme {
                Surface(
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityComposeUIGenerator()
                }
            }
        }
    }

    override fun initiateViewModel(){
        this.viewModel.initiateViewModel()
        startObservingToViewModel()
    }

    override fun startObservingToViewModel(){

        this.viewModel.getWizardListPreparedValue().observe(this, Observer<Boolean> {
            if(this.viewModel.getWizardListPreparedValue().value == true){
                this.wizardList.addAll(this.viewModel.getAllWizardsList())
                Log.d(logTag, "Cantidad de Magos recibidos ${this.wizardList.size}")
                prepareWizardListToShow()
            }
        })

        this.viewModel.getHouseListPreparedValue().observe(this, Observer<Boolean> {
            if(this.viewModel.getHouseListPreparedValue().value == true){
                this.houseList.addAll(this.viewModel.getAllHouseList())
                Log.d(logTag, "Cantidad de Casas recibidos ${this.houseList.size}")
                prepareHouseListToShow()
            }
        })

        this.viewModel.getElixirListPreparedValue().observe(this, Observer<Boolean> {
            if(this.viewModel.getElixirListPreparedValue().value == true){
                this.elixirList.addAll(this.viewModel.getAllElixirList())
                Log.d(logTag, "Cantidad de Elixires recibidos ${this.elixirList.size}")
                prepareElixirListToShow()
            }
        })

    }

    override fun prepareWizardListToShow() {
        Toast.makeText(this, "Mostramos los Magos.",Toast.LENGTH_SHORT).show()
    }

    override fun prepareHouseListToShow() {
        Toast.makeText(this, "Mostramos las Casas.",Toast.LENGTH_SHORT).show()
    }

    override fun prepareElixirListToShow() {
        Toast.makeText(this, "Mostramos los Elixires.",Toast.LENGTH_SHORT).show()
    }

}