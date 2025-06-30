//
//  TrafficCard.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025
//  Letzte update 08.06.2025
//

package de.thkoeln.vma.trafficcounter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic

@Composable
fun TrafficCard(traffic: Traffic, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Typ: ${traffic.getTrafficTypeDisplayName()}")
                Text("Datum: ${traffic.date}")
                Text("Notiz: ${traffic.note}")
                Text("Niederschlag: ${if (traffic.precipitation) "Ja" else "Nein"}")
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Löschen")
            }
        }
    }
}
