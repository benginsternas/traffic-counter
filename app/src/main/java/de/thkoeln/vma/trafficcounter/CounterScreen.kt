//
//  CounterScreen.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025
//

package de.thkoeln.vma.trafficcounter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDateTime

// Composable für den CounterScreen
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

        // Button zum Hinzufügen von Radfahrer:in
        Button(onClick = {
            viewModel.bikeCount.value++
            viewModel.addTraffic(Traffic(Traffic.TrafficType.CYCLING, LocalDateTime.now(), "Haupteingang"))
        }) {
            Text("Radfahrer:in")
        }

        // Button zum Hinzufügen von Fußgänger:in
        Button(onClick = {
            viewModel.pedestrianCount.value++
            viewModel.addTraffic(Traffic(Traffic.TrafficType.FOOT, LocalDateTime.now(), "Haupteingang"))
        }) {
            Text("Fußgänger:in")
        }

        // Button zum Zurücksetzen der Zähler
        Button(onClick = {
            viewModel.resetTraffic()
        }) {
            Text("Reset")
        }

        // Button zur Navigation zur Liste
        Button(onClick = { navController.navigate("list") }) {
            Text("Zur Liste")
        }
    }
}