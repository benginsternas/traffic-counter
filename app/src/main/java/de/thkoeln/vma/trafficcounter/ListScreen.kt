package de.thkoeln.vma.trafficcounter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel

@Composable
fun ListScreen(navController: NavController, viewModel: TrafficViewModel) {
    val traffics = viewModel.trafficList // Daten aus dem ViewModel

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(traffics) { traffic ->
                TrafficCard(traffic = traffic)
            }
        }
    }
}
