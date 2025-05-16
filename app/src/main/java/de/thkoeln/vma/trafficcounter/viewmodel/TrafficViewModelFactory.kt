package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TrafficViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrafficViewModel::class.java)) {
            return TrafficViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
