package de.thkoeln.vma.trafficcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.thkoeln.vma.trafficcounter.ui.components.TrafficBottomNavigationBar
import de.thkoeln.vma.trafficcounter.ui.components.TrafficTopAppBar
import de.thkoeln.vma.trafficcounter.ui.theme.TrafficCounterTheme
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrafficCounterTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val viewModel: TrafficViewModel = viewModel()

                    Scaffold(
                        topBar = { TrafficTopAppBar(navController) },
                        bottomBar = { TrafficBottomNavigationBar(navController) }
                    ) { innerPadding ->
                        NavHost(navController = navController, startDestination = "counter") {
                            composable("counter") { CounterScreen(navController, viewModel) }
                            composable("list") { ListScreen(navController, viewModel) }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrafficCounterTheme {
        CounterScreen(rememberNavController(), viewModel())
    }
}