package com.example.wizardcompose.features.housesscreen.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.wizardcompose.features.housesscreen.uihousesscreen.HousesScreenComposeUIGenerator
import com.example.wizardcompose.features.housesscreen.viewmodel.HousesScreenViewModel
import com.example.wizardcompose.ui.theme.WizardComposeTheme

class HousesScreenActivity : ComponentActivity() {

    private val viewModel: HousesScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.viewModel.initiateViewModel()

        setContent {
            WizardComposeTheme {
                Surface(
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HousesScreenComposeUIGenerator()
                }
            }
        }
    }

}