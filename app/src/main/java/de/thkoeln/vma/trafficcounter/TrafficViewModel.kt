//
//  TrafficViewModel.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025
//

package de.thkoeln.vma.trafficcounter

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

// ViewModel zur Verwaltung der Zähler und der Liste der erfassten Daten
class TrafficViewModel : ViewModel() {
    // Liste der erfassten Daten
    private val _trafficList = mutableListOf<Traffic>()
    val trafficList: List<Traffic> get() = _trafficList

    // Zähler für Radfahrer:in und Fußgänger:in
    var bikeCount = mutableStateOf(0)
    var pedestrianCount = mutableStateOf(0)
    val totalCount: Int get() = bikeCount.value + pedestrianCount.value

    // Funktion zum Hinzufügen von Daten
    fun addTraffic(traffic: Traffic) {
        _trafficList.add(traffic)
    }

    // Funktion zum Zurücksetzen der Daten
    fun resetTraffic() {
        _trafficList.clear()
        bikeCount.value = 0
        pedestrianCount.value = 0
    }
}