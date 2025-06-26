//
//  TrafficTopAppBar.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 11.05.2025, geupdatet am 14.05 waehrend des Livetermins
//

package de.thkoeln.vma.trafficcounter.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrafficTopAppBar(navController: NavController) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("Traffic Counter") },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menu"
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                DropdownMenuItem(
                    text = { Text("Zähler") },
                    onClick = {
                        navController.navigate("counter")
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Auswertung") },
                    onClick = {
                        navController.navigate("list")
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("TH Köln Website") },
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.th-koeln.de"))
                        context.startActivity(intent)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("TH Köln IWZ Map") },
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.933907078144536,6.988620039426897"))
                        context.startActivity(intent)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Info") },
                    onClick = {
                        navController.navigate("info")
                        expanded = false
                    }
                )
            }
        }
    )
}