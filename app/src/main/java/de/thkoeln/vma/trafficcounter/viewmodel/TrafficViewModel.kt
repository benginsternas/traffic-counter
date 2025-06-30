//
//  TrafficViewModel.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025
//  Letzte update 08.06.2025
//

package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import de.thkoeln.vma.trafficcounter.model.data.repository.TrafficRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class TrafficViewModel(private val repository: TrafficRepository) : ViewModel() {

    val totalTraffic: StateFlow<List<Traffic>> = repository.totalTraffic.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val cyclingTraffic: StateFlow<List<Traffic>> = repository.cyclingTraffic.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val footTraffic: StateFlow<List<Traffic>> = repository.footTraffic.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val bikeCount: StateFlow<Int> = repository.getCyclingTrafficCount().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )

    val pedestrianCount: StateFlow<Int> = repository.getFootTrafficCount().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )

    val totalCount: StateFlow<Int> = repository.getTotalTrafficCount().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )

    fun incrementBikeCount(precipitation: Boolean) {
        viewModelScope.launch {
            repository.insertTraffic(
                Traffic(
                    trafficType = Traffic.TrafficType.CYCLING,
                    date = LocalDateTime.now(),
                    note = "Haupteingang",
                    precipitation = precipitation
                )
            )
        }
    }

    fun incrementPedestrianCount(precipitation: Boolean) {
        viewModelScope.launch {
            repository.insertTraffic(
                Traffic(
                    trafficType = Traffic.TrafficType.FOOT,
                    date = LocalDateTime.now(),
                    note = "Haupteingang",
                    precipitation = precipitation
                )
            )
        }
    }

    fun resetCounts() {
        viewModelScope.launch {
            repository.deleteAllTraffic()
        }
    }

    fun deleteTraffic(traffic: Traffic) {
        viewModelScope.launch {
            repository.deleteTraffic(traffic)
        }
    }
}
