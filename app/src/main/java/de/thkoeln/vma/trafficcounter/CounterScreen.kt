package de.thkoeln.vma.trafficcounter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel
import java.time.LocalDateTime

@Composable
fun CounterScreen(navController: NavController, viewModel: TrafficViewModel) {
    val bikeCount = viewModel.bikeCount.value
    val pedestrianCount = viewModel.pedestrianCount.value
    val totalCount = viewModel.totalCount

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Fahrradverkehr: $bikeCount")
        Text("Fußgängerverkehr: $pedestrianCount")
        Text("Gesamtverkehr: $totalCount")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.incrementBikeCount()
            viewModel.addTraffic(Traffic(Traffic.TrafficType.CYCLING, LocalDateTime.now(), "Haupteingang"))
        }) {
            Text("Fahrradfahrer")
        }
        Button(onClick = {
            viewModel.incrementPedestrianCount()
            viewModel.addTraffic(Traffic(Traffic.TrafficType.FOOT, LocalDateTime.now(), "Haupteingang"))
        }) {
            Text("Fußgänger")
        }
        Button(onClick = { viewModel.resetTraffic() }) {
            Text("Reset")
        }
    }
}
