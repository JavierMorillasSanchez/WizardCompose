package com.example.wizardcompose.features.mainscreen.activity

import android.os.Bundle
import android.util.Log
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
import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
import com.example.wizardcompose.features.mainscreen.viewmodel.MainActivityViewModel
import com.example.wizardcompose.ui.theme.WizardComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainActivityInterface {

    private val logTag = this.javaClass.name

    private val viewModel: MainActivityViewModel by viewModels()

    private var wizardList: ArrayList<Wizard> = arrayListOf()

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

        this.viewModel.observeWizardListPreparedValue().observe(this) {
            if (it != null) {
                this.wizardList.addAll(this.viewModel.getAllWizardsList())
                Log.d(logTag, "Cantidad de Magos recibidos ${this.wizardList.size}")
            }
        }

    }

    override fun prepareListsToShow() {
        TODO("Not yet implemented")
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