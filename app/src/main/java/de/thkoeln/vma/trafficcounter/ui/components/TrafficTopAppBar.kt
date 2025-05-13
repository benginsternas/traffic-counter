package de.thkoeln.vma.trafficcounter.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun TrafficTopAppBar(navController: NavController) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("Traffic Counter") },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Counter Screen") },
                    onClick = {
                        navController.navigate("counter")
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("List Screen") },
                    onClick = {
                        navController.navigate("list")
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("TH Köln") },
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.th-koeln.de"))
                        context.startActivity(intent)
                        expanded = false
                    }
                )
            }
        }
    )
}
