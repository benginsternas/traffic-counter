//
//  MainActivity.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025, geupdatet am 14.05 waehrend des Livetermins
//

package de.thkoeln.vma.trafficcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.thkoeln.vma.trafficcounter.ui.components.TrafficBottomNavigationBar
import de.thkoeln.vma.trafficcounter.ui.components.TrafficTopAppBar
import de.thkoeln.vma.trafficcounter.ui.screens.CounterScreen
import de.thkoeln.vma.trafficcounter.ui.screens.InfoScreen
import de.thkoeln.vma.trafficcounter.ui.screens.ListScreen
import de.thkoeln.vma.trafficcounter.ui.theme.TrafficCounterTheme
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrafficCounterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val viewModel: TrafficViewModel = viewModel()

                    Scaffold(
                        topBar = { TrafficTopAppBar(navController) },
                        bottomBar = { TrafficBottomNavigationBar(navController) }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "counter",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("counter") {
                                CounterScreen(
                                    navController = navController,
                                    viewModel = viewModel
                                )
                            }
                            composable("list") {
                                ListScreen(
                                    navController = navController,
                                    viewModel = viewModel
                                )
                            }
                            composable("info") {
                                InfoScreen(
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}