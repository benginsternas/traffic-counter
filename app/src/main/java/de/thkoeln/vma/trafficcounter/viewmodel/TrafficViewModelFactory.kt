//
//  TrafficViewModelFactory.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 11.05.2025, geupdatet am 14.05 waehrend des Livetermins
//
package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TrafficViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrafficViewModel::class.java)) {
            return TrafficViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}