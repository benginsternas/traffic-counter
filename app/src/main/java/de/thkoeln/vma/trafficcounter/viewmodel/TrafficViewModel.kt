package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import de.thkoeln.vma.trafficcounter.Traffic

class TrafficViewModel : ViewModel() {
    // Liste der erfassten Daten
    private val _trafficList = mutableListOf<Traffic>()
    val trafficList: List<Traffic> get() = _trafficList

    // Zähler für Fahrradfahrer und Fußgänger
    var bikeCount = mutableStateOf(0)
    var pedestrianCount = mutableStateOf(0)
    val totalCount: Int get() = bikeCount.value + pedestrianCount.value

    // Funktionen zum Hinzufügen und Zurücksetzen der Daten
    fun addTraffic(traffic: Traffic) {
        _trafficList.add(traffic)
    }

    fun resetTraffic() {
        _trafficList.clear()
        bikeCount.value = 0
        pedestrianCount.value = 0
    }
}
