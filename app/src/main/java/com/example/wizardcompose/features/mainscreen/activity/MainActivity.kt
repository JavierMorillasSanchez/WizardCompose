package com.example.wizardcompose.features.mainscreen.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.wizardcompose.features.mainscreen.uimainscreen.MainActivityComposeUIGenerator
import com.example.wizardcompose.features.mainscreen.viewmodel.MainActivityViewModel
import com.example.wizardcompose.ui.theme.WizardComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.viewModel.initiateViewModel()

        setContent {
            WizardComposeTheme {
                Surface(
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityComposeUIGenerator(viewModel, this)
                }
            }
        }
    }

}