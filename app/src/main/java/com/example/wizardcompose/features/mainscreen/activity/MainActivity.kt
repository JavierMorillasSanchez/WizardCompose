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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initiateViewModel()

        setContent {
            WizardComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun initiateViewModel(){
        this.viewModel.initiateViewModel()
        startListeningToViewModel()
    }

    override fun startListeningToViewModel(){

        this.viewModel.observeWizardListPreparedValue().observe(this, Observer<Boolean> {
            if (it != null) {
                if(this.viewModel.observeWizardListPreparedValue().value == true){
                    this.wizardList.addAll(this.viewModel.getAllWizardsList())
                    Log.d(logTag, "Cantidad de Magos recibidos ${this.wizardList.size}")
                }
            }
        })

        this.viewModel.observeHouseListPreparedValue().observe(this, Observer<Boolean> {
            if (it != null) {
                if(this.viewModel.observeHouseListPreparedValue().value == true){
                    this.houseList.addAll(this.viewModel.getAllHouseList())
                    Log.d(logTag, "Cantidad de Casas recibidos ${this.houseList.size}")
                }
            }
        })

        this.viewModel.observeElixirListPreparedValue().observe(this, Observer<Boolean> {
            if (it != null) {
                if(this.viewModel.observeElixirListPreparedValue().value == true){
                    this.elixirList.addAll(this.viewModel.getAllElixirList())
                    Log.d(logTag, "Cantidad de Elixires recibidos ${this.elixirList.size}")
                }
            }
        })

        prepareListsToShow()
    }

    override fun prepareListsToShow() {
        Toast.makeText(this, "Mostramos los listados.",Toast.LENGTH_SHORT).show()
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WizardComposeTheme {
        Greeting("Android")
    }
}