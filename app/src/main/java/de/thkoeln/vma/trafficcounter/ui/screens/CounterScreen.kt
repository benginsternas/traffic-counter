//
// CounterScreen.kt
// TrafficCounter
// Erstellt von Bengin Sternas am 16.04.2025
// Letzte update 08.06.2025
//

package de.thkoeln.vma.trafficcounter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.thkoeln.vma.trafficcounter.ui.components.CleanDatabaseDialog
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel

@Composable
fun CounterScreen(navController: NavController, viewModel: TrafficViewModel) {
    val bikeCount by viewModel.bikeCount.collectAsState(initial = 0)
    val pedestrianCount by viewModel.pedestrianCount.collectAsState(initial = 0)
    val totalCount by viewModel.totalCount.collectAsState(initial = 0)
    val showDialog = remember { mutableStateOf(false) }
    val isPrecipitationChecked = remember { mutableStateOf(false) }

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

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isPrecipitationChecked.value,
                onCheckedChange = { isChecked -> isPrecipitationChecked.value = isChecked }
            )
            Text("Niederschlag")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.incrementBikeCount(isPrecipitationChecked.value)
        }) {
            Text("Radfahrer:in")
        }
        Button(onClick = {
            viewModel.incrementPedestrianCount(isPrecipitationChecked.value)
        }) {
            Text("Fußgänger:in")
        }
        Button(onClick = { showDialog.value = true }) {
            Text("Reset")
        }
    }

    if (showDialog.value) {
        CleanDatabaseDialog(
            onDismissRequest = { showDialog.value = false },
            onConfirmation = {
                viewModel.resetCounts()
                showDialog.value = false
            },
            dialogText = "Sind Sie sicher, dass Sie alle Daten löschen möchten?",
            icon = Icons.Filled.Warning
        )
    }
}