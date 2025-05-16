//
//  TrafficCard.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025, geupdatet am 14.05 waehrend des Livetermins
//

package de.thkoeln.vma.trafficcounter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.format.DateTimeFormatter

@Composable
fun TrafficCard(traffic: Traffic) {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(traffic.getTrafficTypeDisplayName())
        Spacer(modifier = Modifier.width(8.dp))
        Text(traffic.date.format(formatter))
        Spacer(modifier = Modifier.width(8.dp))
        Text(traffic.note)
    }
}