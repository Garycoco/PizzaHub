package com.datamateappdev.pizzahub

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import com.datamateappdev.pizzahub.data.local.LocalPizzaDataProvider
import com.datamateappdev.pizzahub.screens.home.HomeViewModel
import com.datamateappdev.pizzahub.ui.theme.PizzaHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val homeUiState by viewModel.uiState.collectAsStateWithLifecycle()
            PizzaHubTheme {
                MyApp(items = LocalPizzaDataProvider.allPopularPizza)
            }
        }
    }
}