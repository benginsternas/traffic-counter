//
//  TrafficViewModelFactory.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 11.05.2025
//  Letzte update 08.06.2025
//
package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.thkoeln.vma.trafficcounter.model.data.repository.TrafficRepository

class TrafficViewModelFactory(private val repository: TrafficRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrafficViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TrafficViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}