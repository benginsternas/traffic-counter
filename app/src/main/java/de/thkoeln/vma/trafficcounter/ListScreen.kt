//
//  ListScreen.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025
//

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

// Composable für den ListScreen
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
        // Liste der erfassten Daten
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(traffics) { traffic ->
                TrafficCard(traffic = traffic)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button zur Navigation zurück zum Zähler
        Button(onClick = { navController.navigate("counter") }) {
            Text("Zurück zum Zähler")
        }
    }
}
