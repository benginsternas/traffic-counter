//
//  Traffic.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025, geupdatet am 14.05 waehrend des Livetermins
//

package de.thkoeln.vma.trafficcounter

import java.time.LocalDateTime

data class Traffic(
    val trafficType: TrafficType,
    val date: LocalDateTime,
    val note: String
) {
    enum class TrafficType {
        CYCLING, FOOT
    }

    fun getTrafficTypeDisplayName(): String {
        return when (trafficType) {
            TrafficType.CYCLING -> "Rradfahrer:in"
            TrafficType.FOOT -> "Fußgänger:in"
        }
    }
}