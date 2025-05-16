//
//  TrafficBottomNavigationBar.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 11.05.2025, geupdatet am 14.05 waehrend des Livetermins
//

package de.thkoeln.vma.trafficcounter.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun TrafficBottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Add, contentDescription = "Zähler") },
            label = { Text("Zähler") },
            selected = currentRoute == "counter",
            onClick = { navController.navigate("counter") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Auswertung") },
            label = { Text("Auswertung") },
            selected = currentRoute == "list",
            onClick = { navController.navigate("list") }
        )
    }
}