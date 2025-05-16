//
//  TrafficViewModel.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025, geupdatet am 14.05 waehrend des Livetermins
//

package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import de.thkoeln.vma.trafficcounter.Traffic
import java.time.LocalDateTime

class TrafficViewModel : ViewModel() {
    // Liste der erfassten Daten
    private val _trafficList = mutableListOf<Traffic>()
    val trafficList: List<Traffic> get() = _trafficList

    // Zähler für Radfahrer:in und Fußgänger:in
    var bikeCount = mutableStateOf(0)
    var pedestrianCount = mutableStateOf(0)
    val totalCount: Int get() = bikeCount.value + pedestrianCount.value

    // Funktionen zum Hinzufügen und Zurücksetzen der Daten
    fun addTraffic(traffic: Traffic) {
        _trafficList.add(traffic)
    }

    fun incrementBikeCount() {
        bikeCount.value++
        addTraffic(Traffic(Traffic.TrafficType.CYCLING, LocalDateTime.now(), "Haupteingang"))
    }

    fun incrementPedestrianCount() {
        pedestrianCount.value++
        addTraffic(Traffic(Traffic.TrafficType.FOOT, LocalDateTime.now(), "Haupteingang"))
    }

    fun resetCounts() {
        _trafficList.clear()
        bikeCount.value = 0
        pedestrianCount.value = 0
    }
}